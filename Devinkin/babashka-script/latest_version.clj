#!/usr/bin/env bb
(ns latest-version
  (:require [clojure.java.shell :refer [sh]]
            [clojure.string :as str]
            [clojure.edn :as edn]))

(defn package-latest-version
  "get the latest-version of the package"
  []
  (let [package-name (first *command-line-args*)
        package-map {:deps {(symbol package-name) {:mvn/version "RELEASE"}}}
        res (sh "clojure" "-Sdeps" (str package-map) "-Stree")
        tree (:out res)
        lines (str/split tree #"\n")
        top-level (remove #(str/starts-with? % " ") lines)
        deps (map #(str/split % #" ") top-level)
        version-map (reduce (fn [acc [dep version]]
                              (assoc acc dep version))
                            {}
                            deps)

        ]
    (println (str "package " package-name " latest version: " (get version-map package-name)))
    ))

(package-latest-version)
