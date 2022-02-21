// CSE 143 AW with Esteban
// Homework 8
// Chingpo Lin
// 3/4/2018
// a HuffmanNode class that store a tree about with all relative
// information like its data and frequency, and what is in its left
// and right.

public class HuffmanNode implements Comparable<HuffmanNode> {
   public int data;
   public int freq;
   public HuffmanNode left;
   public HuffmanNode right;
   
   // constructs a HuffmanNode with given data, frequency and what is stored
   // in its left and right.
   public HuffmanNode(int data, int freq, HuffmanNode left, HuffmanNode right) {
      this.data = data;
      this.freq = freq;
      this.left = left;
      this.right = right;
   }
   
   // compare two HuffmanNode object, and returns the difference of their
   // frequency.
   public final int compareTo(HuffmanNode other) {
      return freq - other.freq;
   }
}