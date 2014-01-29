(ns repository.file
  (:require [clojure.java.io :as io :only [file]])
  (:require [clojure.core.async :as async :refer :all]))

(defn ls [path]
  (let [root (io/file path)]

    (map #(.getName %) (.listFiles root))))

(defn load-content [] (prn "load"))


(defn collect-lines
  "Streams line by line to a chanel, once the file is complete the chanel is closed"
  [file-path my-chan]
  (with-open [content (io/reader (io/file file-path))]
    (let [line-s (line-seq content) ]
      (doseq [ln line-s]
        (>!! my-chan ln))))
  (close! my-chan))


(defn line-chanel
  "Returns a chanel that will pipe lines from the file. The streaming will be executed
  in a separate thread"
  [file-path]
  (let [line-stream-chan (chan 10)]
    (thread (collect-lines file-path line-stream-chan)) line-stream-chan ))

