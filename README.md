🕹️ Hangman Game in Java (Console-based)

A simple console-based implementation of the classic Hangman game written in Java. The game randomly selects a word from a dictionary file and allows the player to guess letters until the word is completed or they run out of lives.

## 📦 Features

- Loads words from a text file (`usa.txt`)
- Randomly selects a word for the player to guess
- Letter-by-letter input and validation
- ASCII art Hangman drawing based on remaining lives
- Result is saved to a file (`results.txt`): either "won" or "lost"

## 🎮 How It Works

1. The game starts and loads words from `java/fisiere/usa.txt`.
2. It randomly selects one word.
3. The user guesses letters one at a time.
4. If the letter is correct, it is revealed in the word.
5. If incorrect, the user loses a life (total 6 lives).
6. ASCII art is drawn to represent the hangman.
7. When the word is guessed or all lives are lost, the result is saved to `java/fisiere/results.txt`.

