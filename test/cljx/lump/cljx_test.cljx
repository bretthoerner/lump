(ns lump.cljx-test
  #+clj (:require [clojure.test :as t
                   :refer (is deftest with-test run-tests testing)])
  #+cljs (:require-macros [cemerick.cljs.test
                           :refer (is deftest with-test run-tests testing test-var)])
  #+cljs (:require [cemerick.cljs.test :as t]))

(deftest simple
  (testing "1 + 1 = 2"
    (is (= 2 (+ 1 1)))))
