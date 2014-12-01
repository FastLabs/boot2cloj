(ns repository.meta)

(def party {:id         "party-id"
            :alt-id-set #{{:value1 "v1" :alt-id-type :local-cpt-id}
                          {:value1 "v2" :alt-id-type :paragon-org-id}}
            :name "oleg"}

  )

(defn oracle-struct-map [] {:PARTY_ID [:id]
                         :PARTY_NAME [:name]})
;; oracle structure type set
;; should be extracted from db metadat
(def oracle-struct #{:PARTY_ID :PARTY_NAME})


(defn flat-to-struct
  "flaterns a map to an oracle data structure"
  [instance struct-map]
  (let [paths (map #(get struct-map % :na) oracle-struct )]
    (prn paths)
    (get-in instance paths)))

;; functions to experiment with:
;; juxt - takes few functions and call them on the same structure and the return
;; is added in an arrya
;;

;; select-keys selects all the entries with the keys

;;vals returns a sequence of the values in the map
;;assoc-in