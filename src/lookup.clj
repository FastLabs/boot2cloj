 (ns lookup
   (:import (clojure.lang APersistentMap)))

 (defmulti lookup-currency
           "" class
           (defmethod lookup-currency APersistentMap [_ mapa] (prn mapa)))
(defn currency [currency-code]
  {:code currency-code :id "1"})