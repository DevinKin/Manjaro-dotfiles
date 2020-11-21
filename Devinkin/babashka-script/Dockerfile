FROM borkdude/babashka
RUN echo '(println "Your command line args:" *command-line-args*)' >> script.clj


ENTRYPOINT ["bb", "script.clj"]
