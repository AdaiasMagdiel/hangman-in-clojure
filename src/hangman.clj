(ns hangman
  (:gen-class)
  (:require [hangman.utils :as utils]))

(def chances (atom 5))
(def letters (atom []))

(defn get-letter []
  (print "Enter a letter: ")
  (flush)
  (let [input (read-line)]
  (let [letter (first input)]
  (println letter))))

(defn -main [& args]
  (println (utils/get-lines "src/words.txt"))
  (println (utils/get-line "src/words.txt")))
