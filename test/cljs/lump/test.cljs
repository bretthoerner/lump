(ns lump.test
  (:use [lump.core :only (example-fn)])
  (:require-macros [cemerick.cljs.test
                    :refer (is deftest with-test run-tests testing test-var)])
  (:require [cemerick.cljs.test :as t]))


(deftest test-example-fn
  (is (= 2 (example-fn 1 1))))
