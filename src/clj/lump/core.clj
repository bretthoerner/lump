(ns lump.core
  (:gen-class)
  (:use [compojure.handler :only (site)]
        [compojure.route :refer (resources)]
        [compojure.core :only (defroutes GET POST DELETE ANY)]
        [cemerick.austin.repls :refer (browser-connected-repl-js)]
        ring.middleware.transit
        org.httpkit.server
        hiccup.page)
  (:require [lump.transit :as transit]
            [clojure.tools.logging :as log]
            [ring.util.response :as r]))

(set! *warn-on-reflection* true)

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
       (r/response {::foo 1 ::bar (java.util.Date.)})))

(def app
  (-> routes
      (wrap-transit-response {:encoding :json, :opts {}})
      (wrap-transit-body {:keywords? true :opts {}})
      (wrap-transit-params {:opts {}})))

(defn run
  []
  (let [port 9090]
    (log/info (str "http://localhost:" port "/"))
    (defonce ^:private server
      (run-server (site #'app) {:port port})))
  server)

(defn -main
  [& args]
  (run))
