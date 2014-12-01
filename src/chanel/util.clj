(ns chanel.util
  (:require [clojure.core.async :as async]))

(defn dry-chanel [pipe consumer]
  (loop [line (async/<!! pipe)]
    (when (not (nil? line)) (apply consumer [line])
                            (recur (async/<!! pipe))))
  )