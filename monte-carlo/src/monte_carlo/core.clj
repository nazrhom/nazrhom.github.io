(ns monte-carlo.core
  (:gen-class))


(defn gen-rand-seq
  ([] (repeatedly 1000 #(rand-int 2))))

(defn check
  [bankroll  i]
  (if (pos? i)
    (do 1)
    (do (if (neg? bankroll)
          (do (* 2 bankroll))
          (do -1)
        )
    )
  )
)

(defn deposit
  [bankroll bank]
    (if (> bankroll 0)
        (do (inc bank))
        (do bank)
    )
)

(defn simulate
  [rand-seq]
  (loop [i 0
        bankroll -1
        bank 0]
    (if (< i (count rand-seq))
      (do (recur (inc i) (check bankroll (nth rand-seq i)) (deposit bankroll bank)))
      (do (- bank (- (* bankroll bankroll) 1)))
    )
  )
)



(defn -main
  "Accepts an int and returns a list of n sequences of 1000 random coin flips"
  [& args]
  (if (empty? args)
    (do (println (reduce + (map simulate (repeatedly 1000 gen-rand-seq)))))
    (do (println (reduce + (map simulate (repeatedly (read-string (first  args)) gen-rand-seq)))))
  )
)

(defn mytest
  []
  (let [bankroll 2]
    (if true
      (do (inc bankroll))
      (do (dec bankroll))
    )
  )
)
