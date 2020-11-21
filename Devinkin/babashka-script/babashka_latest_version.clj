#!/usr/bin/env bb
 (require '[clojure.java.shell :refer [sh]]
          '[cheshire.core :as json])

(defn babashka-latest-version
  "Fetch latest Github release tag"
  []
  (->
    (sh "curl" "https://api.github.com/repos/borkdude/babashka/tags")
    :out
    (json/parse-string true)
    first
    :name))

(babashka-latest-version)
