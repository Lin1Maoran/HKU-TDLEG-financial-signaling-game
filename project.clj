(defproject financial-signaling-game "0.1.0-SNAPSHOT"
:description "Clojuring a financial signaling game"
:url "http://example.com/FIXME"
:license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
:dependencies [[org.clojure/clojure "1.10.3"]
               [techascent/tech.ml.dataset "6.042"]
               [org.clojure/math.numeric-tower "0.0.5"]
               [scicloj/scicloj.ml "0.1.1"] ]
:main financial-signaling-game.core
:repl-options {:init-ns financial-signaling-game.core})

