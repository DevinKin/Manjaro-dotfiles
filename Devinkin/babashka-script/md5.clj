#!/usr/bin/env bb
 (ns md5
   (:require [clojure.string :as str])
   (:import (java.security MessageDigest)
            (java.math BigInteger)))

(defn md5
  "using md5 algorithm encrypt string"
  [^String s]
  (let [md5num (->> s
                 .getBytes
                 (.digest (MessageDigest/getInstance "MD5"))
                 (BigInteger. 1))]
    (println "字符串：" s)
    (println "16位小写：" (format "%x" md5num))
    (println "16位大写：" (str/upper-case (format "%x" md5num)))
    (println "32位小写：" (format "%032x" md5num))
    (println "32位大写：" (str/upper-case (format "%032x" md5num)))
    ))

(md5 (first *command-line-args*))
