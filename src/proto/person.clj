(ns proto.person
  (:use flatland.protobuf.core)
  (:import Person$Persona Person$Address Person$Telephone)
  )

(def Persona (protodef Person$Persona))
(def Address (protodef Person$Address))
(def Telephone (protodef Person$Telephone))
