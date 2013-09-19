;; Anything you type in here will be executed
;; immediately with the results shown on the
;; right.
(use 'repository.file)
(use 'clojure.java.io)
(ls "/")
(load)

(doc as-file )
(seq(keys (ns-publics 'clojure.java.io)))

(.exists(file "/" "Users" "linabulavitchi"))
(.exists (file "/Users/linabulavitchi"))

