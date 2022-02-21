import java.util.*;
public class testit{
   public static void main(String[] args) {
      String s = "a      bcd      e";
      String[] temp = s.split("[ ]+");
      System.out.println(Arrays.toString(temp));
      System.out.println((int)(Math.random() * 5));
   }
   
}