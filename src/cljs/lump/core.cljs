(ns lump.core
  (:require [clojure.browser.repl]
            [cognitect.transit :as t]))

(enable-console-print!)

(def r (t/reader :json))
