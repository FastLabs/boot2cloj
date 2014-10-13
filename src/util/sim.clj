(ns util.sim
  (:require [clojure.core.async :refer [chan timeout go thread >! >!!] :refer-macros [>! >!!] ]))

(defn sim-go-channel
  "Simulates a string line producer in a go block"
  []
  (let [c (chan)]
    (go (loop [it-count 10]
          (if-not (> 0 it-count ) (do (timeout 1000) (>! c (str "Hello-" it-count)) (prn it-count) (recur (dec it-count))) )
          ))
     c ))

(defn sim-thread-channel
  "Simulates a string line producer in a thread block"
  []
  (let [c (chan 10)]
    (thread (loop [it-count 10]
          (if-not (> 0 it-count ) (do (timeout 10000) (>!! c (str "Hello-" it-count)) (prn it-count) (recur (dec it-count))) )
          ))
    c ))



