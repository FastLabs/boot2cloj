(ns proto.person
  (:use flatland.protobuf.core)
  (:import Person$Persona Person$Address)
  )

(def Persona (protodef Person$Persona))
(def Address (protodef Person$Address))
