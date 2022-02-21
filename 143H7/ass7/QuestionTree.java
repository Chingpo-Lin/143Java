// CSE 143 AW with Esteban
// Homework 7
// Chingpo Lin
// 2/28/2018
// a QuestionTree class that can create or read a content of a tree, 
// and there is a series of questions in the tree. These questions can be
// answered by computer automatically at the end, and it will create more
// questions and answers if the computer get wrong.

import java.util.*;
import java.io.*;

public class QuestionTree {
   
   private QuestionNode tree;
   private Scanner console;
   
   // constructs the tree with just a data computer, and constructs
   // scanner for user to input something.
   public QuestionTree() {
      tree = new QuestionNode("computer", null, null);
      console = new Scanner(System.in);
   }
   
   // create a tree by taking a scanner and using it.
   public void read(Scanner input) {
      tree = createTree(input);
   }
   
   // a helper method that create all answer in form of leaf, and create
   // the questions in node form, and return that tree.
   private QuestionNode createTree(Scanner input) {
      String next = input.nextLine();
      if (next.startsWith("Q")) {
         return new QuestionNode(input.nextLine(), createTree(input), createTree(input));
      }else {
         return new QuestionNode(input.nextLine(), null, null);
      }
   }
   
   // write the tree by taking a PrintStream parameter, and write down the
   // questions and answers of the tree.
   public void write(PrintStream output) {
      write(output, tree);
   }
   
   // write the question and answer in PrintStream by taking PrintStream and 
   // QuestionNode as parameter, and all the questions
   // are in non-leaf form while answers are in leaf form.
   private void write(PrintStream output, QuestionNode tree) {
      if (tree != null) {
         if (tree.left != null || tree.right != null) {
            output.println("Q:");
            output.println(tree.data);
         }else {
            output.println("A:");
            output.println(tree.data);
         }
         write(output, tree.left);
         write(output, tree.right);
      }
   }
   
   // change the tree by receiving some questions entered by user, and the tree
   // will be changed when the computer get a wrong guess.
   public void askQuestions() {
      tree = askQuestions(tree);
   }
   
   // taking the tree as parameter and changes the tree by adding a question
   // and an answer and returns the new tree.
   private QuestionNode askQuestions(QuestionNode tree) {
      if (tree != null) {
         if (tree.left == null && tree.right == null) {
            if (yesTo("Would your object happen to be " + tree.data + "?")) {
               System.out.println("Great, I got it right!");
            }else {
               System.out.print("What is the name of your object? ");
               String name = console.nextLine();
               System.out.println("Please give me a yes/no question that");
               System.out.println("distinguishes between your object");
               System.out.print("and mine--> ");
               String question = console.nextLine();
               QuestionNode object = new QuestionNode(name, null, null);
               QuestionNode before = new QuestionNode(tree.data, null, null);
               if (yesTo("And what is the answer for your object?")) {
                  return new QuestionNode(question, object, before);
                  }else {
                     return new QuestionNode(question, before, object);
                  }
               }
            }else {
               if (yesTo(tree.data)) {
                  tree.left = askQuestions(tree.left);
               }else {
                  tree.right = askQuestions(tree.right);
               }
            }   
         }
      return tree;
   }
   
   // post: asks the user a question, forcing an answer of "y " or "n";
   //       returns true if the answer was yes, returns false otherwise
   public boolean yesTo(String prompt) {
      System.out.print(prompt + " (y/n)? ");
      String response = console.nextLine().trim().toLowerCase();
      while (!response.equals("y") && !response.equals("n")) {
         System.out.println("Please answer y or n.");
         System.out.print(prompt + " (y/n)? ");
         response = console.nextLine().trim().toLowerCase();
      }
      return response.equals("y");
   }  
}