(ns lump.core
  (:gen-class)
  (:use [compojure.handler :only (site)]
        [compojure.route :refer (resources)]
        [compojure.core :only (defroutes GET POST DELETE ANY)]
        [cemerick.austin.repls :refer (browser-connected-repl-js)]
        org.httpkit.server
        hiccup.page)
  (:require [cognitect.transit :as transit]
            [clojure.tools.logging :as log]))


(defroutes routes
  (resources "/")
  (GET "/" []
       (html5 [:head
               [:script {:src "/goog/base.js" :type "text/javascript"}]
               [:script {:src "/app.js" :type "text/javascript"}]
               [:script {:type "text/javascript"} "goog.require(\"lump.core\");"]]
              [:body
               [:p "Hello, world."]
               (when-let [repl-js (browser-connected-repl-js)]
                 [:script {:type "text/javascript"} repl-js])])))


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
