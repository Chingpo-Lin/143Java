// CSE 143 AW with Esteban
// Homework 7
// Chingpo Lin
// 2/28/2018
// a QuestionNode class that store a tree about question and answer.

public class QuestionNode {

   public String data;
   public QuestionNode left;
   public QuestionNode right;
   
   // construct a QuestionNode with a given data and what is in the left
   // and right of that data.
   public QuestionNode(String data, QuestionNode left, QuestionNode right) {
      this.data = data;
      this.left = left;
      this.right = right;
   }
}