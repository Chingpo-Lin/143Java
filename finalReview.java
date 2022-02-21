import java.util.*;
import java.io.*;
public class finalReview {
   public static void main(String[] args) throws FileNotFoundException {
      Scanner input = new Scanner(new File("Filetest2.txt"));
      Random rand = new Random();
      int[] list = {1, 2, 3, 1, 2, 3, 3} ;
      int[] list2 = {123, 321};
      ArrayList<Integer> array = new ArrayList<Integer>();
      for (int i = 0; i < list.length; i++) {
         array.add(list[i]);
      }
      
      System.out.println(count("SSS", "Assssdssss"));
      /*System.out.println(Arrays.toString(list));
      evenOdd(list);
      System.out.println(Arrays.toString(list));*/
   }
   public static void reportScore(Scanner input) {
      while(input.hasNextLine()) {
         int countNum = 0;
         int countStar = 0;
         String name = "";
         String line = input.nextLine();
         Scanner lineScan = new Scanner(line);

         while(lineScan.hasNextInt()) {
            int temp = lineScan.nextInt();
            String tempNext = lineScan.next();
            if (tempNext.equals("*")) {
               countStar += temp;
            }else if (tempNext.equals("-")) {
               countNum += temp;
            }
         }         
         name = lineScan.next();
         System.out.println(name + " got " + (countStar - countNum) + " of " + (countStar + countNum));
      }    
   }
   public static void reverseAndFlip(Scanner input) {
      while(input.hasNextLine()) {
         String line = input.nextLine();
         if (input.hasNextLine()) {
            String line2 = input.nextLine();
            for (int i = line2.length() - 1; i >= 0;i--) {
               System.out.print(line2.charAt(i));
            }
            System.out.println();
         }
         System.out.println(line);
      }
   }
   public static boolean isPairwiseSorted(int[] list) {
      for (int i = 0; i < list.length - 1; i += 2) {
         if (list[i] > list[i + 1]) {
            return false;
         }
      }
      return true;
   }
   public static void reverse3(ArrayList<Integer> list) {
      for (int i = 0; i < list.size() - 2; i += 3) {
         int temp = list.get(i);
         list.set(i, list.get(i + 2));
         list.set(i + 2, temp);
      }
   }
   public static boolean isMatch(String pattern, String target) {
      int count = 0;
      int num = -1;
      if (pattern.indexOf("*") >= 0) {
         if(pattern.length() < target.length()) {
            count = target.length() - pattern.length();
         }
         if((pattern.length() - 1) > target.length()) {
            return false;
         }
      }else {
         if(pattern.length() != target.length()) {
            return false;
         }
      }
      for (int i = 0; i < pattern.length(); i++) {
         num++;
         if (pattern.charAt(i) != '*') {
            if((pattern.charAt(i) != '.') && (pattern.charAt(i) != target.charAt(num))) {
               return false;
            }
         }else {
            num += count;
         }
      }
      return true;
   }
   public static void adjustTV(Scanner input) {
      boolean power = false;
      int volumn = 0;
      String power2 = "off";
      
      while (input.hasNext()) {
         String scan = input.next();
         if (scan.equals("power")) {
            System.out.println(scan);
            
            power = !power;
         }else {
            int add = input.nextInt();
            if(power){
               volumn += add;
            }
         }
      }
      
      if (power == true) {
         power2 = "on";
      }
      System.out.println("The TV is " + power2);
      System.out.println("The volume is " + volumn);
   }
   public static void blackjack(Scanner input) {
      int sum = 0;
      while (input.hasNext()) {
         if (input.hasNextInt()) {
            sum += input.nextInt();
         }else {
            if (input.next().equalsIgnoreCase("A")) {
               sum += 11;
            }else {
               sum += 10;
            }
         }
         input.next();
      }
      System.out.print(sum);
   }
   public static void censorNames(Scanner input) {
      while (input.hasNext()) {
         System.out.print(input.next() + " ");
         int namex = input.next().length();
         for(int i = 0; i < namex; i++) {
            System.out.print("x");
         }
         System.out.println();
      }
   }
   public static void analyzeParagraphs(Scanner input) {
      int lineCount = 0;
      while (input.hasNextLine()) {
         String line = input.nextLine();
         if (!line.equals("<p>")) {
            lineCount++;
         }else {
            System.out.println(lineCount + " -line paragraph");
            lineCount = 0;
         }
      }
   }
   public static void collapse(ArrayList<String> list) {
      int num = 0;
      int size = list.size() / 2;
      for (int i = 0; i < size; i ++) {
         list.set(num, list.get(i) + list.remove(i + 1));
         num++;
      }  
   }
   public static void manyStrings(ArrayList<String> list, int num) {
      int size = list.size();
      for (int i = size - 1; i >= 0; i--) {
         for (int k = 1; k < num; k++) {
            list.add(i, list.get(i));
         }
      }
   }
   public static void oddsToBack(ArrayList<Integer> list) {
      int num = 0;
      for (int i = 0; i < list.size(); i++) {
         if (list.get(i) % 2 == 0) {
            list.add(num, list.remove(i));
            num++;
         }
      }
   }
   public static void banish(int[] array1, int[] array2) {
      for (int i = 0; i < array2.length; i++) {
         for (int k = 0; k < array1.length; k++) {
            if (array2[i] == array1[k]) {
               for (int j = k; j < array1.length - 1; j++) {
                  array1[j] = array1[j + 1];
               }
               array1[array1.length] = 0;
               k--;
            }
         }
      }
   }
   public static void expand(ArrayList<Integer> list) {
      int size = list.size() - 2;
      for (int i = size; i >= 0; i -= 2) {
         int num = list.remove(i);
         int num2 = list.get(i);
         for (int k = 1; k < num; k++) {
            list.add(i, num2);
         }
      }
   }
   public static void rearrange(ArrayList<Integer> list) {
      
      for (int i = 1; i < list.size() / 2 + 1; i++) {
         list.add(list.remove(i));
      }
   }
   public static void evenOdd(int[] list) {
      int oddIndex = 1;
      for (int i = 0; i < list.length; i += 2) {
         if (list[i] % 2 == 1) {
            int temp = list[oddIndex];
            list[oddIndex] = list[i];
            list[i] = temp;
            i -= 2;
            oddIndex += 2;
         }
      }
   }
   public static void tokenStats(Scanner input) {
      int integer = 0;
      double realnum = 0.0;
      int tokens = 0;
      while (input.hasNext()) {
         if (input.hasNextInt()) {
            integer += input.nextInt();
         }else if (input.hasNextDouble()) {
            realnum += input.nextDouble();
         }else {
            input.next();
         }
         tokens++;
      }
      System.out.println("Integer = " + integer);
      System.out.println("real number = " + realnum);
      System.out.println("tokens = " + tokens);
   }
   public static boolean areDeepMirrors(int[] list1, int[] list2) {
      for (int i = 0; i < list1.length; i++) {
         int count = 0;
         int num = list1[i];
         //String temp = "" + list[i];
         //temp.length()
         while (num != 0) {
            num = num / 10;
            count++;
         }
         for (int j = 1; j < count; j++) {
            int first = list1[i] % (int)Math.pow(10, j) / (int)Math.pow(10, j - 1);
            int second = list2[list2.length - i - 1] % (int)Math.pow(10, count - j + 1) / (int)Math.pow(10, count - j);
            if (first != second) {
               return false;
            }
         }
      }
      return true;
   }
   public static boolean blackjack(Random rand) {
      int sum = 0;
      while (sum < 18) {
         int temp = rand.nextInt(10) + 1;
         sum += temp;
         System.out.print(temp + " ");
      }
      System.out.print("= " + sum + " ");
      if (sum > 21) {
         System.out.print("Busted! ");
         return false;
      }else if(sum == 21) {
         System.out.print("BLACKJACK! ");
      }
      return true;
   }
   public static int count(String s1, String s2) {
      int count = 0;
      s1 = s1.toLowerCase();
      s2 = s2.toLowerCase();
      while (s2.indexOf(s1) >= 0) {
         s2 = s2.substring(0, s2.indexOf(s1)) + s2.substring(s2.indexOf(s1) + 1);
         count++;
      }
      return count;
   }
   public static String encode(String s1, int num) {
      String s2 = "";
      int temp = 0;
      while (s1.length() != s2.length()) {
         for (int i = temp; i < s1.length(); i += num) {
            s2 += s1.substring(i, i + 1);
         }
         if (temp < num) {
            temp++;
         }
      }
      return s2;
   }
   public static boolean hasTwoPair(int[] list) {
      int total = 0;
      for (int i = 0; i < list.length; i++) {
         int k = 0;
         for (int j = 0; j < list.length; j++) {
            if (list[i] == list[j]) {
               k++;
            }
         }
         if (k == 2) {
            total++;
         }
      }
      if (total == 4) {
         return true;
      }else {
         return false;
      }
   }
   public static void printReversed(String s1) {
      s1 = " " + s1;
      for (int i = 1; i < s1.length(); i++) {
         if ((s1.charAt(i - 1) == ' ') && (s1.charAt(i) != ' ')) {
            String temp = s1.substring(i);
            int index = temp.indexOf(" ");
            temp = temp.substring(0, index);
            for (int j = index - 1; j >= 0; j--) {
               System.out.print(temp.substring(j, j + 1));
            }
         }else if (s1.charAt(i) == ' ') {
            System.out.print(" ");
         }
      }
   }
}