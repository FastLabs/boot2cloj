(ns stream.csv-test
  (:require [clojure.test :refer :all]
            [stream.csv :refer :all]))

(defn- accum-to [atm-container]
  (fn [item] (swap! atm-container #(conj %1 item))))

(deftest test-simple
  (let [file-name "./test/stream/temp.csv"
        accum (atom [])]
    (stream-csv-file file-name (accum-to accum))
    (prn @accum)
    (is (= 3 (count @accum)))))
