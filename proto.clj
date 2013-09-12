(use 'flatland.protobuf.core)
(import Person$Persona)
(import Person$Address)

(def Persona (protodef Person$Persona))
(def Address (protodef Person$Address))

(def p1 (protobuf Persona :id 1 :name "Oleg"
                  :address (protobuf Address :street "oak way" :postCode "TW18AT")
                  :likes ["Ioana" "Luca" "Lina"]))

(:postCode(:address p1))

(def saved (protobuf-dump p1))

(def loaded (protobuf-load Persona saved))

(:postCode(:address loaded))
(:likes loaded)

;;worked on first namespace integration

(use 'flatland.protobuf.core)
(require '[proto.person :as person])

(def p1 (protobuf person/Persona :id 1 :name "Oleg"
                  :address (protobuf person/Address :street "oak way" :postCode "TW18AT"
                                     :telephone (protobuf person/Telephone :phone "123"))
                  :likes ["Ioana" "Luca" "Lina"]))

(def saved (protobuf-dump p1))

(def loaded (protobuf-load person/Persona saved))
(:telephone (:address p1))

;;


(use 'flatland.protobuf.core)
(import zorg.PersonMessage)
(import zorg.Persona)

(def PersMessage (protodef zorg.PersonMessage {:naming-strategy  (reify flatland.protobuf.PersistentProtocolBufferMap$Def$NamingStrategy
                          (protoName [this clojure-name]
                            (name clojure-name))
                          (clojureName [this proto-name]
                            (keyword proto-name)))}))

(def Pers (protodef zorg.Persona))
(def Telephone (protodef zorg.Telephone))
(def Address (protodef zorg.Address))
(def Family (protodef zorg.Family))

(def pm (protobuf PersMessage
                  :sex :MALE
                  :persona (protobuf Pers :id 1 :name "Oleg"
                                     :address (protobuf Address :street "Oak way"
                                                        :postcode "TW14 8AT"
                                                        :telephone (protobuf Telephone :area "11")))
                  :myFamily (protobuf Family :name "zozo")))

(def saved (protobuf-dump pm))
(def loaded (protobuf-load PersMessage saved))
loaded
