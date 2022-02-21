// Stuart Reges 
// CSE 143 AW with Esteban
// Homework 6
// Chingpo Lin
// 2/20/2018
// A AnagramSolver class that prints all of devided form of a given
// words in a given amount. These combination words are choosen from
// a dictionary.

import java.util.*;

public class AnagramSolver {

   // stores words in dictionary with its LetterInventory form.
   private Map<String, LetterInventory> map;
   private List<String> dictionary;

   // construct a map with all of words in dictionary which written in 
   // LetterInventory form.
   public AnagramSolver(List<String> list) {    
      map = new HashMap<String, LetterInventory>();
      dictionary = list;
      for (String s: list) {
         LetterInventory word = new LetterInventory(s);
         map.put(s, word);
      }
   }  
   
   // pre : max should not be negative, throw IllegalArgumentException
   // otherwise
   // post: create the String in LetterInventory form, and create
   // a ArrayList to store the possible combination
   public void print(String s, int max) {
      if (max < 0) {
         throw new IllegalArgumentException();
      }
      LetterInventory word = new LetterInventory(s);
      List<String> combination = new ArrayList<String>();
      print(combination, word, max);
   }
   
   // if the max is 0, prints all of possibility of combination, else, prints
   // all of possibility that the amount of combination less than or equals 
   // to max.
   private void print(List<String> combination, LetterInventory word, int max) {
      if (word.isEmpty() && (combination.size() <= max || max == 0)) {
         System.out.println(combination);         
      }else {
         for (String s: dictionary) {
            if (word.subtract(map.get(s)) != null) {
               combination.add(s);
               print(combination, word.subtract(map.get(s)), max);
               combination.remove(s);
            }
         }
      }
   }
}