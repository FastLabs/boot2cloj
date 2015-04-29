(ns stream.csv
  (:require [clojure.java.io :as io]
            [clojure.data.csv :as csv]))

(defn- csv-decoder [receiver]
  (let [header (atom [])]
    (fn [line]
      (when-not (compare-and-set! header [] (map keyword line))
        (receiver (zipmap @header line))))))

(defn stream-csv-file [file receiver]
  (with-open [in (io/reader file)]
    (let [csv-producer (csv-decoder receiver)]
      (doseq [line (csv/read-csv in)]
        (csv-producer line)))))



