// CSE 143 AW with Esteban
// Homework 5
// Chingpo Lin
// 1/27/2018
// A GrammerSolver that can prints a grammar sentence based on a kind of
// words that begins with, there are method to get nonterminal of the grammar
// and generate a given times of a sentences begins with the certain given
// symbol, we can also know if a symbol is a nonterminal.

import java.util.*;

public class GrammarSolver {

   private SortedMap<String, String[]> map;
   
   // pre: the grammar should not be empty and there should not be more
   // than or equals to two tries of one nontermial, 
   // throw IllegalArgumentException otherwise.
   // post: divided all line in grammar by "|" , and store it in array
   // and store in the map with the key which shows in the begining of
   // each line.
   public GrammarSolver(List<String> grammar) {
      if (grammar.size() == 0) {
         throw new IllegalArgumentException();
      }
      map = new TreeMap<String, String[]>();
      for (int i = 0; i < grammar.size(); i++) {
         String temp = grammar.get(i);
         int position = temp.indexOf("=");
         String key = temp.substring(0, position - 2);
         if (grammarContains(key)) {
            throw new IllegalArgumentException();
         }
         temp = temp.substring(position + 1);
         String[] words = temp.split("[|]+");
         map.put(key, words);
      }
   }
   
   // returns if the symbol is a nonterminal
   public boolean grammarContains(String symbol) {
      return map.containsKey(symbol);
   }
   
   // pre: the times should not be negative and the symbol should be
   // contained as a nonterminal, throw IllegalArgumentException otherwise
   // generates a sentence starts with a given symbol, and
   // repeats for a given times 
   public String[] generate(String symbol, int times) {
      if (!grammarContains(symbol) && times < 0) {
         throw new IllegalArgumentException();
      }
      String[] s = new String[times];
      for (int i = 0; i < times; i++) {
         s[i] = generate(symbol).trim();
      }
      return s;
   }
   
   // generates a random kinds of string that begins with a given symbol,
   // and delete all of the leading and tracing whitespace.
   private String generate(String symbol) {
      String temp = "";
      if (!map.containsKey(symbol)) {
         if (!symbol.equals("")) {
            return symbol + " ";
         }
      }else {
         Random rand = new Random();
         int number = rand.nextInt(map.get(symbol).length);
         String[] temp3 = map.get(symbol)[number].trim().split("[ \t]+");
         for (int i = 0; i < temp3.length; i++) {
            temp += generate(temp3[i]);
         }
      }
      return temp;
   }
   
   // gets all of the nonterminal symbols
   public String getSymbols() {
      return map.keySet().toString();
   }
}
