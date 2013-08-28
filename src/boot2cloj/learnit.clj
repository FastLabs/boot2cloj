(def lista '(1 2 3 4 5))
(def vectorul [5 6 7 8 9 10])

(first lista)

(defn scnd [lis]
  (first (rest lis))
 )

;;call
(scnd lista)

(defn third [lis]
  (second (rest lis))
  )
;;call
(third lista)
()

(sequential? lista)
(filter odd? lista)
(first(filter odd? lista))

(reduce + lista)

(map * lista vectorul)
(defn add-squares[data] (map + data) )
(add-squares lista)


(defn factorial [n] (reduce *(range 1 (+ 1 n))))
(factorial 1)
(factorial 0)
(factorial 5)

(defn prefix-of? [prefix data] (map = prefix data))


(source  some)


(prefix-of? [1 3 3] [1 2 3 4 5 6])
;; defective one
(prefix-of? [3 4 5] [4 5 6])

(prefix-of? "oleg" "oleg bulavitchi")
(prefix-of? "lina" "oleg bulavitchi")


