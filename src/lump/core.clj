(ns lump.core
  (:gen-class)
  (:use [compojure.handler :only [site]]
        [compojure.core :only [defroutes GET POST DELETE ANY]]
        org.httpkit.server
        hiccup.core)
  (:require [cognitect.transit :as transit]))


(defroutes routes
  (GET "/" [] (html [:body [:p "Hello, world."]])))


(defn -main
  [& args]
  (run-server (site #'routes) {:port 9090}))
