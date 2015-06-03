(defproject calculator-ws "0.1.0"
  :description "Simple JAX-WS in Clojure"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]]
  :plugins      [[lein-servlet "0.4.1"]]
  :aot          [calculator_ws.core]
  :servlet      {:webapps {"/" {:servlets {"/calcws" calculator_ws.core.CalcWS}
                                :public "resources"}}})
