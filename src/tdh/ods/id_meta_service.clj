(ns tdh.ods.id-meta-service)

(defprotocol IdMetaProvider
  (get-id-meta [this system entity-name] [this entity-name]))

