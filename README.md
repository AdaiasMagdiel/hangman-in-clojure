# Simple Hangman Game in Clojure (WIP)

> This project is under construction.

This is a simple Clojure project where I developed a hangman game as part of my language study.

## Project Structure

The project has the following folder structure:

```
/
└── src
    ├── hangman.clj
    ├── words.txt
    └── hangman
        └── utils.clj
```

The `hangman.clj` file contains the main source code of the game, while `words.txt` is a file storing the words used in the game. The `utils.clj`, in the `hangman` folder, contains some functions to manipulate the words list.

## How to Play

Make sure you have the Clojure environment installed on your machine.

You can run the game as follows:

```bash
$ clj -M -m hangman
```

This will start the game, and you can begin playing!

## Features

The game includes the following features:

-   Random selection of a word from the `words.txt` file.
-   Prompting the user to guess a letter.
-   Counting chances to guess the word.

## Contributing

Contributions are welcome! Feel free to submit pull requests with improvements or fixes.

## License

The project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
