(ns destruct)

(def x [1 2 3 4 {:a "unu" :b "doi"}])

;;vector destructuring
(let [[x y _ _ mapa] x] (+ x y) mapa)
(let [[x & rst] x] rst)
;indexed vector de-structuring
(let [{m 1} x] m)

;;map destructuring
(def maps {:unu "oleg" :doi "bulavitchi"})

(let [{nume :unu prenume :doi} maps] (str nume " " prenume))


(defn name-it [m]
  (let [{name :unu } m]
    name)
 )


(name-it maps)

;;another example

(def map1 {:a 5 :b 6
           :c [7 8 9]
           :d {:e 10 :f 11}
           "foo" 88
           42 false})

(let [{a :a b :b} map1] (+ a b))

(let [{f "foo"} map1] (+ f 12))

(let [{v 42} map1] (if v 1 0))

(let [{f 0 t 4}[1 2 3 4 5]] (+ f t))

(let [{[x _ y]:c}map1] (+ x y))

(def map-in-vector ["Oleg" {:birthday (java.util.Date. 78 11 7)}])

(let [[name {birthday :birthday}]map-in-vector]
  (str name " was born on " birthday))

(let [[x _ y :as original-vector][1 2 3 4]]
  (conj original-vector (+ x y)))



