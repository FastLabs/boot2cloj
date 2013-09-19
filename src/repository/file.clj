(ns repository.file
  (:use clojure.java.io))

(defn ls [path]
  (prn "list")
  (let [root (file path)]

    (map #(.getName %) (.listFiles root))
    )
  )

(defn load [] (prn "load"))
