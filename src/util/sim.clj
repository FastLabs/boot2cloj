(ns util.sim
  (:require [clojure.core.async :refer [chan timeout go ] :refer-macros [>!] ]))

(defn sim-channel []
  (let [c (chan)]
    (go (loop [it-count 10]
          (if-not (> 0 it-count ) (do (timeout 1000) (>! c "Hello") (prn it-count) (recur (dec it-count))) )
          ))
     c ))


