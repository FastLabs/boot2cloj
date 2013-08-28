(use 'clojure.xml)
(require  '[clojure.zip :as zip])

(import java.io.File)

(def input (File. "src/boot2cloj/doc.xml"))
(.exists input)
(.getCanonicalPath input)
(def cnt (parse input))

(def zipa (zip/xml-zip cnt))

(defn flattern [zp]
  (loop [data zp]
    (if (zip/end? data)
        []
      (doseq []
        (prn (if(zip/branch? data) (first (zip/node data)) "2"))
        (recur (zip/next data)))
      )
    )
  )
(flattern zipa)

;;(-> zipa first :tag)
