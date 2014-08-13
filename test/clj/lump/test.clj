(ns lump.test
  (:require [clojure.test :refer :all]
            [lump.core :refer :all]))


(deftest math!
  (testing "1 + 1 = 2"
    (is (= 2 (+ 1 1)))))
