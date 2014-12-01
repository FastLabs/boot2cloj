(ns oracle.meta)


(defn map-meta-extractor
  "temporary meta-repository"
  []
  (let [types {:TYP_OBJ_POSITION [:POSITION_ID :PARTY_ID]}]
    (fn [type-name]  (get types type-name))))

(defn meta-repository [meta-extractor]
  (let [meta-cache (atom {})]
    (fn [type-name]
      (if-let [content (get @meta-cache type-name)]
        content
        (let [extracted (meta-extractor type-name)]
          (do
            (swap! meta-cache (fn [c] (assoc c type-name extracted) ))
              extracted))))))

(def meta-provider (meta-repository (map-meta-extractor)  ))
