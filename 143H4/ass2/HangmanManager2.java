// CSE 143 AW with Esteban
// Homework 4 bonus
// Chingpo Lin
// 2/15/2018
// A HangmanManager2 class that override the record, guesses and words method
// to increase the difficulty of the game.

import java.util.*;
public class HangmanManager2 extends HangmanManager {
   private Set<String> words;
   private SortedSet<Character> guessLetter;
   private int guessTime;
   private boolean successGuess;
   private boolean change;
   
   // extends HangmanManager's constructor and make some field unmodifiable.
   public HangmanManager2(Collection<String> dictionary, int length, int max) {
      super(dictionary, length, max);
      words = Collections.unmodifiableSet(super.words());
      guessLetter = Collections.unmodifiableSortedSet(super.guesses());
      guessTime = max;
      successGuess = false;
      change = false;
   }
   
   // if there is just one chance left, this will primarily make client lose 
   public int record(char letter) {
      successGuess = false;
      change = false;
      int size = super.words().size();
      Set<String> tempSet = super.words();
      SortedSet<Character> tempSortedSet = super.guesses();
      if (guessesLeft() == 1) {
         String temp = "";
         boolean exist = true;
         for (String s: words) {
            if (!s.contains("" + letter) && exist == true) {
               exist = false;
               temp = s;
            }
         }
         if (!exist) {
            tempSet.clear();
            tempSet.add(temp);
            guessTime--;
         }
      }
      guessTime--;
      int number = super.record(letter);
      if (super.words().size() != size) {
         change = true;
      }
      tempSortedSet.add(letter);
      successGuess = true;
      return number;
   }
   
   // gets the character which has been guessed 
   public SortedSet<Character> guesses() {
      if (successGuess) {
         guessLetter = Collections.unmodifiableSortedSet(super.guesses());
      }
      return guessLetter;
   }
   
   // gets the words in current set.
   public Set<String> words() {
      if (change) {
         words = Collections.unmodifiableSet(super.words());
      }
      return words;
   }
}