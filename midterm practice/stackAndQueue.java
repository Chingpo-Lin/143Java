import java.util.*;
public class stackAndQueue {
   public static void main(String[] args) {
      Stack<Integer> s = new Stack<Integer>();
      Queue<Integer> q = new LinkedList<Integer>();
      s.push(2); 
      s.push(1);
      s.push(-1);
      s.push(1);
      cancel(s);
      q.add(5);
      q.add(3);
      q.add(6);
      q.add(7);
      q.add(4);
      makeSortedSequence(q);
      System.out.println(q);
   }
   public static void cancel(Stack<Integer> s) {
   
      Stack<Integer> s2 = new Stack<Integer>();
      while (!s.isEmpty()) {
         int temp = s.pop();
         int temp2 = 0;
         if (!s.isEmpty()) {
            temp2 = s.pop();
         }
         while (temp + temp2 == 0) {
            temp = temp2;
            if (!s.isEmpty()) {
               temp2 = s.pop();
            }
         }
         s2.push(temp);
      }
      while (!s2.isEmpty()) {
         s.push(s2.pop());
      }
   }
   public static void collapse(Stack<Integer> s) {
      int temp = s.size();
      Queue<Integer> q = new LinkedList<Integer>();
      if (temp % 2 == 1) {
         q.add(s.pop());
      }
      for (int i = 0; i < temp - 1; i += 2) {
          int first = s.pop();
          int second = 0;
          if (!s.isEmpty()) {
              second = s.pop();   
          }
          q.add(first + second);
      }
       while (!q.isEmpty()) {
           s.push(q.remove());   
       }
       while (!s.isEmpty()) {
           q.add(s.pop());   
       }
       while (!q.isEmpty()) {
           s.push(q.remove());   
       }
   }
   public static void makeSortedSequence(Queue<Integer> q) {
      int first = q.remove();
      q.add(first);
      int temp = 1;
      Stack<Integer> s = new Stack<Integer>();
      int size = q.size();
      for (int i = 1; i < size; i++) {
         int num = q.remove();
         if (num >= first) {
            q.add(num);
            temp++;
         }else {
            s.push(num);
         }
      }
      while (!s.isEmpty()) {
         q.add(s.pop());
      }
      for (int j = 0; j < temp; j++) {
         q.add(q.remove());
      }
      for (int k = 0; k < size - temp; k++) {
         s.push(q.remove());
      }
      while (!s.isEmpty()) {
         q.add(s.pop());
      }
   }
}