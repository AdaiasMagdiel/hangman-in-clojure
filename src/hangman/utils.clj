(ns hangman.utils
  (:gen-class)
  (:require [clojure.java.io :as io]))

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
