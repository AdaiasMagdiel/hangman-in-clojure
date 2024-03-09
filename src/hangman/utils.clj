(ns hangman.utils
  (:gen-class)
  (:require [clojure.java.io :as io])
  (:require [clojure.string :as str]))

(defn generate-secret-word [string]
	(repeat (count string) \_))

(defn show-string
	([string] (str/join string))
	([string join] (str/join join string)))

(defn list-contains? [collection value]
  (some #(= value %) collection))

(defn istr-contains? [s value]
  (not (nil? (str/index-of s (str/lower-case value)))))

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
