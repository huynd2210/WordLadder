# WordLadder

Solver for word game Word Ladder

The game consists of "moving" to an objectives by linking words together e.g 
Start: DEAD
Objective: WORD
Solution: DEAD -> HEAD -> HERD -> HARD -> WARD -> WORD

This program accepts a start string and an objective string as input and prints the solution to the objective

How this algorithm works: 
- Create a graph from word list in which a word (vertex) is connected to another word if their transposition distance is 1 
(i.e "HEAD" and "HERD" has a transposition distance of 1 ('A' -> 'R"))
- Using Dijstra Algorithm to find the shortest path (if available) from the start string to the objective string
- Prints out the path
