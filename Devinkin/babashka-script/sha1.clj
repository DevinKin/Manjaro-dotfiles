#!/usr/bin/env bb
(ns sha1)

(defn sha1
  "using sha1 algorithm encrypt string"
  [s]
  (let [hashed (.digest (java.security.MessageDigest/getInstance "SHA-1")
                        (.getBytes s))
        sw (java.io.StringWriter.)]
    (binding [*out* sw]
      (doseq [byte hashed]
        (print (format "%02X" byte))))
    (str sw)))

(sha1 (first *command-line-args*))
