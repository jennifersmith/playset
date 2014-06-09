(ns playset.core)

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


(defn is-set? [cards]
  (let [card-count (count cards)
        combined-attribute-counts (map count (map set (apply map vector cards)))]
    (empty?
     (remove (set [1 card-count])
             combined-attribute-counts))
    ))
