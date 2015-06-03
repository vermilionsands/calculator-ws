(ns calculator_ws.core
  (:import [javax.xml.bind.annotation XmlType]))

(deftype CalculatorRqst [x y])

(gen-class
  :name calculator_ws.core.Factory
  :prefix factory-
  :methods [^{:static true} [rqst [] calculator_ws.core.CalculatorRqst]])

(defn factory-rqst [] (CalculatorRqst. 0 0))

(definterface ICalculatorRqst
  (^Long getX [])
  (^Long getY [])
  (^void setX [^Long q])
  (^void setY [^Long w]))

(deftype ^{XmlType {factoryMethod "rqst"
                    factoryClass calculator_ws.core.Factory}}
    CalculatorRqst [^Long ^:unsynchronized-mutable x
                    ^Long ^:unsynchronized-mutable y]
  ICalculatorRqst
  (getX [this] x)
  (getY [this] y)
  (setX [this q] (set! x q))
  (setY [this q] (set! y q)))

(gen-class
  :name ^{javax.jws.WebService {}
          javax.jws.soap.SOAPBinding {style javax.jws.soap.SOAPBinding$Style/RPC}}
        calculator_ws.core.CalcWS
  :prefix ws-
  :methods [[add [^{javax.jws.WebParam {name "values"}} calculator_ws.core.CalculatorRqst] Long]])

(defn ws-add [this rqst]
  (+ (.getX rqst) (.getY rqst)))
