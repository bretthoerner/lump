(ns lump.core
  (:gen-class)
  (:use [compojure.handler :only (site)]
        [compojure.route :refer (resources)]
        [compojure.core :only (defroutes GET POST DELETE ANY)]
        [cemerick.austin.repls :refer (browser-connected-repl-js)]
        org.httpkit.server
        hiccup.page)
  (:require [lump.transit :as transit]
            [clojure.tools.logging :as log]
            [ring.util.response :as r]))

(defn with-content-type [body content-type]
  (r/header (r/response body) "Content-Type" content-type))

(defroutes routes
  (resources "/")
  (GET "/" []
       (html5 [:head
               [:script {:src "js/out/goog/base.js" :type "text/javascript"}]
               [:script {:src "js/lump.js" :type "text/javascript"}]
               [:script {:type "text/javascript"} "goog.require(\"lump.core\");"]]
              [:body
               [:p "Hello, world."]
               (when-let [repl-js (browser-connected-repl-js)]
                 [:script {:type "text/javascript"} repl-js])]))
  (GET "/transit-example" []
       (with-content-type
         (transit/write {::foo 1 ::bar (java.util.Date.)})
         "application/transit+json"))
  (GET "/transit-examplev" []
       (with-content-type
         (transit/writev {::foo 1 ::bar (java.util.Date.)})
         "application/json")))

(defn run
  []
  (let [port 9090]
    (log/info (str "http://localhost:" port "/"))
    (defonce ^:private server
      (run-server (site #'routes) {:port port})))
  server)

(defn -main
  [& args]
  (run))
