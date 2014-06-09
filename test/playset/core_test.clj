(ns playset.core-test
  (:require [clojure.test :refer :all]
            [playset.core :refer :all]))

(deftest generate-expected-set-cards-with-two-attribs
  (is (= (generate-set-cards [:green :yellow] [1 2]) 
         #{[:green 1] [:green 2] [:yellow 1] [:yellow 2]})))

(deftest is-set?-recognises-set
  (is (= true (is-set? [[:green 1] [:blue 1] [:red 1]]))))

(deftest is-set?-recognises-non-set
  (is (= false (is-set? [[:blue 1] [:blue 1] [:red 1]]))))
