#!/usr/bin/env bb

(ns doc
  (:require [clojure.repl :refer [doc]]))


(defmacro doc-by-text []
  "doc by input text"
  (let [[text _] *command-line-args*
        sym (symbol text)]
    `(doc ~sym)
    ))

(doc-by-text)
