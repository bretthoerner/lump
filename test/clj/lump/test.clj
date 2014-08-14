(ns lump.test
  (:require [clojure.test :refer :all]
            [lump.core :as lump]))

(deftest simple
  (testing "1 + 1 = 2"
    (is (= 2 (+ 1 1)))))
