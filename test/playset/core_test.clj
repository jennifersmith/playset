(ns playset.core-test
  (:require [clojure.test :refer :all]
            [playset.core :refer :all]))

(deftest generate-set-cards-with-two-attribs
  (is (= (generate-set-cards [:green :yellow] [1 2]) 
         #{[:green 1] [:green 2] [:yellow 1] [:yellow 2]}
         )))

