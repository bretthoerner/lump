(ns lump.cljx-test
  #+clj (:require [clojure.test :as t
                   :refer (is deftest with-test run-tests testing)])
  #+cljs (:require-macros [cemerick.cljs.test
                           :refer (is deftest with-test run-tests testing test-var)])
  #+cljs (:require [cemerick.cljs.test :as t]))


(deftest cljx-test
  (is (= 1 1)))
