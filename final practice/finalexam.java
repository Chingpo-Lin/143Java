import java.util.*;
public class finalexam {
   public static void main(String[] arg) {
      Set<Integer> set = new TreeSet<Integer>();
      set.add(1);
      set.add(2);
      Iterator<Integer> it = set.iterator();
      while (it.hasNext()) {
         int temp = it.next();
         if (temp == 1) {
            it.remove();
         }
      }
      System.out.println(set);
   }
}