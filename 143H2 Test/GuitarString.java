// Stuart Reges
// CSE 143 AW with Esteban
// Homework 2
// Chingpo Lin
// 1/14/2018
// a GuitarString class that we can pluck the string, tic the string 
// and get the sample of the string.

import java.util.*;

public class GuitarString {
   
   private Queue<Double> buffer;
   
   // this stores the energy decay factor.
   public static final double DECAY = 0.996;
   
   // pre: the frequency should more than or equal 0, and the number that will stores in
   // buffer should more than 2, otherwise throws IllegalArgumentException.
   // post: take frequency as parameter, and divided by Sample rate to get the size of
   // buffer, than add 0 to buffer to that size.
   public GuitarString(double frequency) {
      int N = (int)Math.round(StdAudio.SAMPLE_RATE / frequency);
      if (frequency <= 0 || N < 2) {
         throw new IllegalArgumentException();
      } 
      buffer = new LinkedList<Double>();
      for (int i = 0; i < N; i++) {
         buffer.add(0.0);
      }
   }
   
   // this is the same as the constructer before, but it add the double stored
   // in the init to buffer instead of 0.
   public GuitarString(double[] init) {
      this(StdAudio.SAMPLE_RATE * 1.0 / init.length);
      for (int i = 0; i < init.length; i++) {
         buffer.remove();
         buffer.add(init[i]);
      }
   }
   
   // replaces N elements in the buffer with random number between -0.5 inclusive
   // and +0.5 exclusive.
   public void pluck() {
      Random rand = new Random();
      for (int i = 0; i < buffer.size(); i++) {
         buffer.remove();
         buffer.add(rand.nextDouble() - 0.5);
      }
   }
   
   // this remove the front of the buffer and add the average of the first two element
   // to the end and times energy decay factor.
   public void tic() {
      buffer.add((buffer.remove() + sample()) / 2 * DECAY);
   }
   
   // this get the first element in the buffer.
   public double sample() {
      return buffer.peek();
   }
}
