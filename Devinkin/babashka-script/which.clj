#!/usr/bin/env bb
(ns which
  (:require [clojure.pprint :refer [pprint]]
            [clojure.java.io :as io]))

(defn which
  "which command implemented in Clojure"
  [executable]
  (let [path (System/getenv "PATH")
        paths (.split path (System/getProperty "path.separator"))]
    (loop [pts paths]
      (when-first [p pts]
        (let [f (io/file p executable)]
          (if (and (.isFile f)
                (.canExecute f))
            (.getCanonicalPath f)
            (recur (rest pts))))))))

(when-let [executable (first *command-line-args*)]
  (println (which executable)))
