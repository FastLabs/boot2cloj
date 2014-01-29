(ns boot2cloj.trade
  (:use repository.file))

(defn month []
  (let [data {:1 "January"
              :2 "February"
              :3 "March"}]
    data))
