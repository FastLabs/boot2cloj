(ns tdh.ods)

(defprotocol ReferenceData
  (find-exception-type [repository excpt-type]))

(defrecord memory-ref [cache] ReferenceData
  (find-exception-type [repository excpt-type]
    (let [{{:keys [:exceptions]} :cache} repository]
      (get exceptions excpt-type))
    )
  )
