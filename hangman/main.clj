(ns hangman.main
  (:gen-class)
  (:require [clojure.java.io :as io]))

(def chances (atom 5))
(def letters (atom []))

(defn choice [collection]
  (let [idx (rand-int (count collection))]
  (let [item (nth collection idx)]
  item)))

(defn get-lines [path]
  (with-open [reader (io/reader path)]
  (reduce conj [] (line-seq reader))))

(defn get-line [path]
  (let [lines (get-lines path)]
  (let [line (choice lines)]
  line)))

(defn get-letter []
  (print "Enter a letter: ")
  (flush)
  (let [input (read-line)]
  (let [letter (first input)]
  (println letter))))

(defn -main []
  (println (get-lines "../words.txt"))
  (println (get-line "../words.txt")))

(-main)
