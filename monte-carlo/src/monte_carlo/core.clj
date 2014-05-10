(ns monte-carlo.core
  (:gen-class))

(defn gen-rand-seq
  ([] (repeatedly 100 #(rand-int 2))))



(defn -main
  "Accepts an int and returns a list of n sequences of 100 random coin flips"
  [& args]
  (if (empty? args)
    (do (println (repeatedly 10 gen-rand-seq)))
    (do (println (repeatedly (read-string (first  args)) gen-rand-seq)))
  )
)
