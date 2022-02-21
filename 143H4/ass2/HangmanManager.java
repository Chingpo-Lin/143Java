// CSE 143 AW with Esteban
// Homework 4
// Chingpo Lin
// 1/27/2018
// A HangmanManager class plays a game of Hangman, there are methods to
// gets the words that we have already guessed and get our correct words'set,
// also, we can know how many chance of guess left, when the client guess a
// character, we get the number of letter in our pattern that we made secretly.

import java.util.*;

public class HangmanManager {
   
   private Set<String> words;
   private SortedSet<Character> guessLetter;
   private int guessTime;
   private String guesses;
   
   // pre: the length of words cannot be less than 1, and the maximum times of
   // guess should not be negative, otherwise throw IllegalArgumentException
   // post: constructs the words of given length, and the guessTime is the
   // max times of guess passed from client, while the guesses is the form
   // of dash, and the guessLetter remains empty before guess.
   public HangmanManager(Collection<String> dictionary, int length, int max) {
      if (length < 1 || max < 0) {
         throw new IllegalArgumentException();
      }
      words = new TreeSet<String>();
      guessLetter = new TreeSet<Character>();
      guesses = "";
      guessTime = max;
      for (int i = 0; i < length - 1; i++) {
         guesses += "- ";
      }
      guesses += "-";
      for (String s: dictionary) {
         if (s.length() == length) {
            words.add(s);
         }
      }
   }
   
   // returns current words that satisfied the pattern
   public Set<String> words() {
      return words;
   }
   
   // returns the chance of guess left
   public int guessesLeft() {
      return guessTime;
   }
   
   // returns the set of guessed character
   public SortedSet<Character> guesses() {
      return guessLetter;
   }
   
   // pre: throw IllegalStateException if the size of words equals zero.
   // post: returns the current pattern in the form of letter and dash
   public String pattern() {
      if (words.size() == 0) {
         throw new IllegalStateException();
      }
      return guesses;
   } 
   
   // pre: the guesses times should more than 0, and the words connot be
   // empty, throw IllegalStateException otherwise. if the word is not
   // empty, but the letter has been guessed before, 
   // throw IllegalArgumentException
   // post: returns the occurences of the character guess in the current 
   // pattern,and add the guess to the guessed letter, and if the final 
   // version of pattern is the same after the guess, guess times 
   // remains unchange, otherwise minus by 1. Also, this will picked the
   // most proper version of pattern to be the current pattern.
   public int record(char guess) {
      if (guessTime < 1 || words.size() < 0) {
         throw new IllegalStateException();
      }
      if (words.size() > 0 && guessLetter.contains(guess)) {
         throw new IllegalArgumentException();
      }
      guessLetter.add(guess);
      Map<String, Set<String>> word = putSet(guess);
      boolean correct = false;
      int max = words.size();
      for (String s: word.keySet()) {
         if (word.get(s).size() > max) {
            max = word.get(s).size();
            guesses = s;
            correct = true;
         }
      }
      if (!correct) {
         guessTime--;
      }
      words = word.get(guesses);
      return getTimes(guess);
   }
   
   // returns a copy of the current words.
   private Set<String> copySet() {
      Set<String> copy = new TreeSet<String>();
      for (String s: words) {
         copy.add(s);
      }
      return copy;
   }
   
   // returns the number of guess in that pattern
   private int getTimes(char guess) {
      int times = 0;
      for (int i = 0; i < guesses.length(); i++) {
         if (guesses.charAt(i) == guess) {
            times++;
         }
      }
      return times;
   }
   
   // returns a map that put all of possible pattern with proper words
   private Map<String, Set<String>> putSet(char guess) {
      Map<String, Set<String>> word = new TreeMap<String, Set<String>>();
      Set<String> copy = copySet();
      word.put(guesses, words);
      for (String s: copy) {
         String temp = guesses;
         for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == guess) {
               temp = temp.substring(0, i * 2) + guess + temp.substring(i * 2 + 1);
            }
         }      
         if (!temp.equals(guesses) && word.containsKey(temp)) {
            words.remove(s);
            word.get(temp).add(s);
         }else if (!word.containsKey(temp)) {
            Set<String> set = new TreeSet<String>();
            set.add(s);
            words.remove(s);
            word.put(temp, set);
         }
      }
      return word;
   }
}