(ns stream.csv
  (:require [clojure.java.io :as io]
            [clojure.data.csv :as csv]))

(defn stream-csv-file [file receiver]
  (with-open [in (io/reader file)]
    (doseq [line (csv/read-csv in)]
      (receiver line))))

(defn csv-decoder [receiver]
  (let [header (atom [])]
    (fn [line]
      (let [first-line @header]
        (if (= 0 (count first-line))
          (swap! header (fn [_] (map keyword line)))
          (receiver (zipmap first-line line)) ))))
  )
