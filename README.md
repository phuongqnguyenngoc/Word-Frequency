# Word-Frequency
This project centers in the application of Binary search tree and recursive methods in searching and storing data. The program is able to take in large text files, and build a BST map of words in which each key is one world and its value is the word's frequency. The program is also able to write out an output file in which there is a total number of words and the frequency of each word. I also write an algorithm to ensure the construction of a balanced tree and an algorithm to print out the tree level by level

This link https://drive.google.com/open?id=1tyK5-L2QqaHipvdiGp_hT5kFYK7AV9AD contains 8 files which record comments on Reddit from 2008 to 2015, namely reddit_comments_20xx.txt in which xx is the 2 last  numbers of the year. These files are large enough that they will crash the programs which use inefficient algorithm. If you want to use any of them, please download and put them in the same directory with the code files. 

To run the based program, run WordCounter.java followed by a text file(s). For example, in the terminal, after compiling, run this line (assumed that you've already download these files):
    java WordCounter reddit_comments_2018.txt reddit_comments_2009.txt
The program will generate 2 files named wordcount1.txt and wordcount2.txt. In the terminal, it also prints out the time it takes to process each file and 10 most common words in each file

To run the balanced tree program, run BalancedTree.java followed by a text file(s) just as above. In the terminal, it will print out the tree layer by layer. Because the tree is balanced, it will take less time to search for a word.








