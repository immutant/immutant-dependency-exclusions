(defproject org.immutant/immutant-dependency-exclusions "0.1.1-SNAPSHOT"
  :description "A tiny util for excluding Immutant dependencies from Leiningen dependency coordinates"
  :url "https://github.com/immutant/immutant-dependency-exclusions"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :profiles {:dev
             {:dependencies [[org.clojure/clojure "1.5.1"]
                             [leiningen-core "2.2.0"]]}}
  :signing {:gpg-key "BFC757F9"}
  :lein-release {:deploy-via :clojars})
