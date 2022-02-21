// Stuart Reges 
// CSE 143 AW with Esteban
// Homework 2
// Chingpo Lin
// 1/14/2018
// a Guitar37 class implements Guitar and has 37 keyboard, client can play a existed note by 
// entering a pitch, and we can check if the keyboard has the string that client enter,
// we can also get the sample which is the sum of String in the list, we can also tic and 
// calculate the tic times.

public class Guitar37 implements Guitar {
   public static final String KEYBOARD =
      "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";  // keyboard layout
      
   private GuitarString[] string37;
   private int tic;
   
   // construct the times of tic to 0, and create 37 GuitarString object to the array.
   public Guitar37() {
      string37 = new GuitarString[37];
      for (int i = 0; i < KEYBOARD.length(); i++) {
         string37[i] = new GuitarString(440.0 * Math.pow(2, (i - 24) / 12.0));
      }
      tic = 0;
   }
   
   // pluck a assigned note by getting the pitch which is the parameter. 
   public void playNote(int pitch) {
      int temp = pitch + 24;
      if (temp <= 36 && temp >= 0) {
         string37[temp].pluck();
      }
   }
   
   // returns whether the key in the keyboard.
   public boolean hasString(char key) {
      return KEYBOARD.contains("" + key);
   }
   
   // pre: the key should be in keyboard, ignored otherwise
   // post: pluck the assigned key by gettring its pitch.
   public void pluck(char key) {
      if (hasString(key)) {
         playNote(KEYBOARD.indexOf("" + key) - 24);
      }
   }
   
   // get the same of all GuitarString's sample in the array.
   public double sample() {
      double sum = 0.0;
      for (int i = 0; i < KEYBOARD.length(); i++) {
         sum += string37[i].sample();
      }
      return sum;
   }
   
   // add 1 to tic, and tic all the GuitarString's element in the array.
   public void tic() {
      tic++;
      for (int i = 0; i < KEYBOARD.length(); i++) {
         string37[i].tic();
      }
   }
   
   // get the times of tic.
   public int time() {
      return tic;
   }
}