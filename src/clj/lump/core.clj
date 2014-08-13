(ns lump.core
  (:gen-class)
  (:use [compojure.handler :only [site]]
        [compojure.route :refer (resources)]
        [compojure.core :only [defroutes GET POST DELETE ANY]]
        [cemerick.austin.repls :refer (browser-connected-repl-js)]
        org.httpkit.server
        hiccup.page)
  (:require [cognitect.transit :as transit]))


;; (def repl-env (reset! cemerick.austin.repls/browser-repl-env
;;                       (cemerick.austin/repl-env)))
;; (cemerick.austin.repls/cljs-repl repl-env)


(defroutes routes
  (resources "/")
  (GET "/" []
       (html5 [:head [:script {:src "/app.js" :type "text/javascript"}]]
              [:body
              [:p "Hello, world."]
              (when-let [repl-js (browser-connected-repl-js)]
                [:script repl-js])])))


(defn run
  []
  (defonce ^:private server
    (run-server (site #'routes) {:port 9090}))
  server)


(defn -main
  [& args]
  (run))
