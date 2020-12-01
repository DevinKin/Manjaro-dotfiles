 #!/usr/bin/env bb
(require '[clojure.java.io :as io]
         '[clojure.string :as str])

(defn get-jar-file
  "get jar file from user.home.m2 directory
  usage: ./ls_jar.clj honeysql/honeysql 1.0.444"
  ([jar-name version]
   (let [arg-cnt (count *command-line-args*)
         file-sep (System/getProperty "file.separator")]
     (if (= 1 arg-cnt)
       (io/file jar-name)
       (let [[_org lib-name] (str/split jar-name #"/")
             jar-path (-> jar-name
                          (str/replace "." file-sep)
                          (str/replace "/" file-sep))]
         (io/file (System/getProperty "user.home")
                  (format (str/join file-sep [".m2" "repository" "%s" "%s" "%s-%s.jar"])
                          jar-path
                          version
                          lib-name version)))))))

(let [jar-name (first *command-line-args*)
      version (second *command-line-args*)]
  (doseq [e (enumeration-seq
             (.entries (java.util.jar.JarFile. (get-jar-file jar-name version))))]
    (println (.getName e))))
