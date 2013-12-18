Letter-Guessing-Thread
=======================

Code was written for my concurrency coursework:

The coursework aims at implementing a simple game to be played by two threads with a textual representation on the console. The game is aimed at teaching touch-typing the home row keys (asdfjkl;). One thread will generate random characters from the home row, with delays becoming smaller as the game progresses. The other thread will model a (very) erratic human who guesses random home row characters. Any occurrence of the guessed character will be deleted from the existing string of generated characters. When the string exceeds 10 characters the game is over and the score for the guessing thread is the number of deleted characters.