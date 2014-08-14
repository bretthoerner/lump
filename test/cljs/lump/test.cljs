(ns lump.test
  (:require-macros [cemerick.cljs.test
                    :refer (is deftest with-test run-tests testing test-var)])
  (:require [cemerick.cljs.test :as t]
            [lump.core :as lump]))

(deftest simple
  (testing "1 + 1 = 2"
    (is (= 2 (+ 1 1)))))
