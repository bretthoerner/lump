(defproject lump "0.1.0-SNAPSHOT"
  :description "Clojure experiment."
  :url "https://github.com/bretthoerner/lump"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2311"]
                 [ring/ring-core "1.3.0"]
                 [javax.servlet/servlet-api "2.5"]
                 [http-kit "2.1.18"]
                 [compojure "1.1.8"]
                 [hiccup "1.0.5"]
                 [com.cognitect/transit-clj "0.8.247"]]
  :main ^:skip-aot lump.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
