(ns playset.core
  (:require [clojure.core.logic :as logic]))

;; can use math.combinatorics here. not gunna.

(defn create-card-tuples
  [[current-attributes & remaining-attributes]]
  (if (seq remaining-attributes) 
    (for [attrib current-attributes
          card (create-card-tuples remaining-attributes)]
      (cons attrib card))
    (map vector current-attributes)))

(defn generate-set-cards [& attributes]
  (set (create-card-tuples attributes)))


;; assumes only three cards

(logic/defne valid-attributeo [attr] 
  ([[n n n]])
  ([attr] (logic/distincto attr)))

(logic/defne valid-seto [cards]
  ([[(a . arest)
     (b . brest)
     (c . crest)]]
     (valid-attributeo [a b c])
     (valid-seto [arest brest crest])
    )
  ([[() () ()]]))

(defn is-set? [cards]
  (first
   (logic/run 1 [n] 
              (logic/matcha [cards n]
                            ([cards true] (valid-seto cards))
                            ([_ false])))))


