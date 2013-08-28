(defproject boot2cloj "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :plugins [[lein-cljsbuild "0.2.7"]]
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-1450"]
                 [org.clojure/clojure-contrib "1.2.0"]
                 ]
  :cljsbuild {
        :builds [{
          :source-path "src/cljs"
          :compiler {
            :output-to "resources/public/hello.js"
            :optimizations :whitespace
            :pretty-print true}}]}

  :main boot2cloj.core)
