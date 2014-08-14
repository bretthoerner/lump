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
                 [com.cognitect/transit-clj "0.8.247"]
                 [com.cognitect/transit-cljs "0.8.178"]
                 [org.clojure/tools.logging "0.3.0"]]
  :hooks [cljx.hooks]
  :main ^:skip-aot lump.core
  :jvm-opts ["-Xmx1g"]
  :target-path "target/%s"
  :source-paths ["src/clj" "target/generated/src/clj"] ;; "src/cljs" ?
  :test-paths ["test/clj" "target/generated/test/clj"]
  ;; :resource-paths ["target/generated/src/cljs"]
  :profiles {:uberjar {:aot :all}
             :dev {:repl-options {:init-ns lump.core}
                   :cljx {:builds [{:source-paths ["src/cljx"]
                                    :output-path "target/generated/src/clj"
                                    :rules :clj}
                                   {:source-paths ["src/cljx"]
                                    :output-path "target/generated/src/cljs"
                                    :rules :cljs}
                                   {:source-paths ["test/cljx"]
                                    :output-path "target/generated/test/clj"
                                    :rules :clj}
                                   {:source-paths ["test/cljx"]
                                    :output-path "target/generated/test/cljs"
                                    :rules :cljs}]}
                   :plugins [[com.cemerick/austin "0.1.3"]
                             [lein-cljsbuild "1.0.3"]
                             [com.cemerick/clojurescript.test "0.3.1"]
                             [com.keminglabs/cljx "0.4.0"]]
                   :cljsbuild {:test-commands {"unit" ["phantomjs"
                                                       :runner "target/cljs/testable.js"]}
                               :builds {:dev
                                        {:source-paths ["src/cljs" "target/generated/src/cljs"]
                                         :compiler {:output-dir "resources/public/js/out"
                                                    :output-to "resources/public/js/lump.js"
                                                    :source-map "resources/public/js/lump.js.map"
                                                    :optimizations :none
                                                    :pretty-print true}}
                                        :test
                                        {:source-paths ["src/cljs" "test/cljs" "target/generated/test/cljs"]
                                         :compiler {:output-to "target/cljs/testable.js"
                                                    :optimizations :whitespace}}}}}})
