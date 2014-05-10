(ns monte-carlo.core
  (:gen-class))

(defn gen-rand-seq
  ([] (repeatedly 100 #(rand-int 2))))






(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (if (empty? args)
    (do (println (repeatedly 10 gen-rand-seq)))
    (do (println (repeatedly (read-string (first  args)) gen-rand-seq)))
  )
)
