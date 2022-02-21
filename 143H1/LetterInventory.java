// Stuart Reges 
// CSE 143 AW with Esteban
// Homework 1
// Chingpo Lin
// 1/9/2018
// A LetterInventory class that can get the count of a given value, and can alter the 
// count of a given value. we can also know the size and if it is empty in this class
// we can also add and substract between 2 LetterInventory variables.

public class LetterInventory {
 
   private int size;
   private int[] letterCount;
   
   // this store the size 26 of the number of letter.
   public static final int SIZE = 26;
   
   // the constructor takes data as parameter and takes all letter to the value of size
   // and also puts the amount of each letter into array.
   public LetterInventory(String data) { 
      data = data.toLowerCase();
      letterCount = new int[SIZE];
      for (int i = 0; i < data.length(); i++) {
         if (alphabetic(data.charAt(i))) {
            // takes only letter into account only
            size++;
            letterCount[data.charAt(i) - 'a'] += 1;
         }
      }
   }
   
   // pre: given letter should be alphabetic (otherwise throws IllegalArgumentException).
   // post: returns the count of a given letter stored in array
   public int get(char letter) {
      if (alphabetic(letter)) {
         return letterCount[Character.toLowerCase(letter) - 'a'];
      }else {
         throw new IllegalArgumentException("please use letter only");
      }
   }
   
   // pre: given letter should be alphabetic, and the value should be non negative.
   // (otherwise throws IllegalArgumentException)
   // post: alters the count of a given value to a given amount by alter 
   // the count of the letter in array.
   public void set(char letter, int value) {
      if (value < 0 || !alphabetic(letter)) {
         throw new IllegalArgumentException("please use letter only");
      }else {
         int temp = Character.toLowerCase(letter) - 'a';
         size -= letterCount[temp];
         letterCount[temp] = value;
         size += value;
      }
   }
   
   // returns the size of letter
   public int size() {
      return size;
   }
   
   // returns whether there is letter in the data
   public boolean isEmpty() {
      return size == 0;
   }
   
   // returns the string in the form of [].
   public String toString() {
      String tempString = "";
      for (int i = 0; i < SIZE; i++) {
         for (int j = 0; j < letterCount[i]; j++) {
            tempString += (char)('a' + i);
         }
      }
      return "[" + tempString + "]";
   }
   
   // takes a LetterInventory object as parameter and gets the String of combination, and 
   // return a new LetterInventory object of the combination.
   public LetterInventory add(LetterInventory other) {
      LetterInventory another = new LetterInventory("");
      for (int i = 0; i < SIZE; i++) {
         char temp = (char)('a' + i);
         another.set(temp, get(temp) + other.get(temp));
      }
      return another;
   }
   
   // pre: the difference of them should be positive, returns null otherwise;
   // pose: takes a LetterInventory object as parameter and gets the String of subtraction, and 
   // return a new LetterInventory object of the subtraction.
   public LetterInventory subtract(LetterInventory other) {
      LetterInventory another = new LetterInventory("");
      for (int i = 0; i < SIZE; i++) {
         char temp = (char)('a' + i);
         int tempInt = get(temp) - other.get(temp);
         if (tempInt >= 0) {
            another.set(temp, tempInt);
         }else {
            return null;
         }
      }
      return another;
   }
   
   // This returns if the letter is alphabetic.
   private boolean alphabetic(char letter) {
      int temp = Character.toLowerCase(letter) - 'a';
      return temp >= 0 && temp < SIZE;
   }
}
