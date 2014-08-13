(ns lump.core
  (:require [clojure.browser.repl]))


(defn hello-world
  []
  (js/alert "Hello, world."))


(defn error-test
  []
  (throw "Error"))
