(ns lump.core
  (:require [clojure.browser.repl]
            [cognitect.transit :as t]))

(enable-console-print!)

(def r (t/reader :json))

(defn transit-test [] (t/read r "{\"~:lump.core/foo\":1,\"~:lump.core/bar\":\"~t2014-08-14T23:29:39.265Z\"}"))
