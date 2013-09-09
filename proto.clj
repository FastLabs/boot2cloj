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

(require '[boot2cloj.core :as core])
(require '[proto.person :as person])

(core/-main)

(core/hellp)

(str core/x)

(str core/y)
(def x person/Persona)

