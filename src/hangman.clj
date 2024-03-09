(ns hangman
  (:gen-class)
  (:require [hangman.utils :as utils])
  (:require [clojure.string :as str]))

(def chances (atom 5))
(def letters (atom []))
(def valid-letters "abcdefghijklmnopqrstuvwxyz")
(def word (str/lower-case (utils/get-line "src/words.txt")))
(def secret-word (atom (utils/generate-secret-word word)))

(defn get-letter []
  (print "Enter a letter: ")
  (flush)
  (let [input (read-line)]
  (let [letter (first input)]
  	(if (nil? (str/index-of valid-letters (str/lower-case letter)))
	  	(get-letter)
	  	(str/lower-case letter)))))

; TODO: Remake this function to work with secret-word as it currently
; does not fill the secret-word correctly.
(defn regenerate-secret-word [word input]
	(let [updated-secret-word (mapv #(if (= % input) input \_) word)]
		updated-secret-word))

(defn show-messages []
	(println "\nThe word has" (count word) "letters.")
  (println "You have" @chances "chances remaining.")
  (println "Letters:" (str/join ", " @letters))
  (println "Word:" (str/join " " @secret-word) "\n"))

(defn game []
	(show-messages)

  (let [letter (get-letter)]
	(if (nil? (str/index-of word letter))
		(swap! chances dec)
		(reset! secret-word (regenerate-secret-word word (char (first letter)))))
	(swap! letters conj letter)))

(defn -main [& args]
  (println "[DEBUG] Word:" word)
  (println "[DEBUG] Hidden Word:" (utils/show-string @secret-word " ") "\n")

  ; TODO: Implement a game loop to run while have remaining chances or the word is not complete.
  (game))
