(defproject boot2cloj "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :plugins [
             ;;[lein-cljsbuild "0.2.7"]
             ;;  [lein-protobuf "0.3.1"]
             ]

  :dependencies [[org.clojure/clojure "1.7.0-beta2"]
                 ;;[org.clojure/clojurescript "0.0-1450"]
                 [org.clojure/clojure-contrib "1.2.0"]
                 [org.clojure/data.csv "0.1.2" ]
                 ;;[org.flatland/protobuf "0.7.2"]
                 [org.clojure/test.check "0.8.0-ALPHA"]
                 ]
  :cljsbuild {
        :builds [{
          :source-path "src/cljs"
          :compiler {
            :output-to "resources/public/hello.js"
            :optimizations :whitespace
            :pretty-print true}}]}

  :main boot2cloj.core)
