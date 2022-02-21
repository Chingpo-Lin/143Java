// CSE 143 AW with Esteban
// Homework 8
// Chingpo Lin
// 3/4/2018
// a HuffmanTree class that can decode and encode about a tree, and we can
// turn the sentence into bits form, and it can also do it reversely.
// it can also write these form after transformation in a file.

import java.util.*;
import java.io.*;

public class HuffmanTree {

   private HuffmanNode tree;
   
   // constructs the tree with the given frequency of a given bits from
   // the parameter count, and it also builds the tree in a special order
   public HuffmanTree(int[] count) {
      Queue<HuffmanNode> huffman = new PriorityQueue();
      for (int i = 0; i < count.length; i++) {
         if (count[i] > 0) {
            huffman.add(new HuffmanNode(i, count[i], null, null));
         }
      }
      huffman.add(new HuffmanNode(count.length, 1, null, null));
      while (!huffman.isEmpty()) {
         tree = huffman.remove();
         if (!huffman.isEmpty()) {
            HuffmanNode second = huffman.remove();
            huffman.add(new HuffmanNode(-1, tree.freq + second.freq, tree, second));
         }
      }
   }
   
   // constructs the tree by taking a scanner of a file which contains bits
   // and transform them into relative character, and store them in the tree.
   public HuffmanTree(Scanner input) {
      while (input.hasNextLine()) {
         int bit = Integer.parseInt(input.nextLine());
         String code = input.nextLine();
         tree = buildTree(bit, code, tree);
      }
   }
   
   // create a bit of -1 in most of node, and for the leaf part, we build
   // it by finding it position by read the code from the scanner. returns
   // the final version of the tree of each code we get from scanner
   private HuffmanNode buildTree(int bit, String code, HuffmanNode tree) {
      if (code.isEmpty()) {
         return new HuffmanNode(bit, -1, null, null);
      }else {
         if (tree == null) {
            tree = new HuffmanNode(-1, -1, null, null);
         }
         if (code.charAt(0) == '1') {
            tree.right = buildTree(bit, code.substring(1), tree.right);
         }else {
            tree.left = buildTree(bit, code.substring(1), tree.left);
         }
         return tree;
      }
   }
   
   // taking BitInputStream, printStream, and an special number named eof as
   // parameter, read the input, and turns them into a relative sentence stored
   // in a output file, and ends after meet a eof.
   public void decode(BitInputStream input, PrintStream output, int eof) {
      int bit = 0;
      while (bit != eof) {
         bit = readTree(input, output, tree, eof);
      }
   }
   
   // if the bit is 1, put it in the right, and if it is 0, put it in the
   // left part of the tree, and if we get eof, then ends, and every time
   // we get a feasible data, we write it in the output.
   private int readTree(BitInputStream input, PrintStream output, HuffmanNode tree, int eof) {
      if (tree.data == eof) { 
         return eof;         
      }else if (tree.data != -1) {
         output.write(tree.data);
         return tree.data;
      }else {
         if (input.readBit() == 1) {
            return readTree(input, output, tree.right, eof);
         }else {
            return readTree(input, output, tree.left, eof);
         }
      }
   }
   
   // write the integer of given character and its positions by using
   // 0 and 1 to describe that charater by taking a PrintStream as parameter.
   public void write(PrintStream output) {
      writeHelper(output, tree, "");
   }
   
   // taking PrintStream, HuffmanNode, and a bit symbolizing the position of
   // that character in the tree, and write it after find that character(in
   // form of leaf in the tree)
   private void writeHelper(PrintStream output, HuffmanNode tree, String bit) {
      if (tree.left == null && tree.right == null) {
         output.println(tree.data);
         output.println(bit);
      }else {
         writeHelper(output, tree.left, bit + "0");
         writeHelper(output, tree.right, bit + "1");
      }
   }
}

