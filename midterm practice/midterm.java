public class midterm {
   public static void main(String[] args) {
      System.out.println();
      writeNumber(5);
   }
   public static String collapseSequence(String s, char c) {
      if (s.length() == 1) {
         return s;
      }else if (s.charAt(0) == c && s.charAt(1) == c) {
         return collapseSequence(s.substring(1), c);
      }else {
         return s.substring(0, 1) + collapseSequence(s.substring(1), c);
      }
   }
   
   public static String commonChars(String s1, String s2) {
      if (s1.length() == 1) {
         if (s1.charAt(0) == s2.charAt(0)) {
            return "" + s1.charAt(0);
         }else {
            return ".";
         }
      }else if (s1.charAt(0) == s2.charAt(0)) {
         return "" + s1.charAt(0) + commonChars(s1.substring(1), s2.substring(1));
      }else {
         return "." + commonChars(s1.substring(1), s2.substring(1));
      }
   }
   
   public static void countToBy(int from, int num) {
      if (num > from) {
         System.out.print(from);
      }else {
         countToBy(from - num, num);
         System.out.print(" " + from);
      }
   }
   
   public static int indexOf(String s1, String s2) {
      if (s1.length() < s2.length()) {
         return -1;
      }else if (s1.substring(0, s2.length()).equals(s2)) {
         return 0;
      }else {
         int count = indexOf(s1.substring(1), s2);
         if (count == -1) {
            return count;
         }else {
            return count + 1;
         }
      }
   }
   public static boolean isPalindrome(String s1) {
      if (s1.length() == 1 || s1.length() == 0) {
         return true;
      }else {
         if (s1.charAt(0) != s1.charAt(s1.length() - 1)) {
            return false;
         }
         return isPalindrome(s1.substring(1, s1.length() - 1));
      }
   }
   public static boolean isSorted(int n) {
      if (n < 0) {
         return isSorted(-n);
      }else if (n == 0) {
         return true;
      }else {
         if (n % 10 < n / 10 % 10) {
            return false;
         }
         return isSorted(n / 10);
      }
   }
   public static int largestDigit(int n) {
      if (n < 0) {
         return largestDigit(-n);
      }
      if (n < 10) {
         return n;
      }else {
         if (n % 10 > n / 10 % 10) {
            return largestDigit(n % 10 + n / 100 * 10);
         }else {
            return largestDigit(n / 10);
         }
      }
   }
   public static void mirrorString(String s) {
      if (s.length() == 1) {
         System.out.print(s);
      }else {
         System.out.print(s.substring(0, 1));
         mirrorString(s.substring(1));
         System.out.print(s.substring(0, 1));
      }
   }
   public static String moveToEnd(String s, char c) {
      if (s.length() == 1 || s.length() == 0) {
         return s;
      }else {
         if (s.charAt(0) == c) {
            return moveToEnd(s.substring(1), c) + c;
         }else {
            return s.substring(0, 1) + moveToEnd(s.substring(1), c);
         }
      }
   }
   public static void parenthesize(int n) {
      if (n < 2) {
         System.out.print(n);
      }else {
         System.out.print("(");
         if (n % 2 == 0) {
            System.out.print(n + " + ");
            parenthesize(n - 1);
         }else {
            parenthesize(n - 1);
            System.out.print(" + " + n);
         }
         System.out.print(")");
      }
   }
   public static void printDashed(int n) {
      if (n < 0) {
         System.out.print("-");
         printDashed(-n);
      }else if(n < 10) {
         System.out.print(n);
      }else {
         printDashed(n / 10);
         System.out.print("-" + n % 10);
      }
   }
   public static void printPattern(int n) {
      if (n == 1) {
         System.out.print(".");
      }else if (n == 0) {
         System.out.print("");
      }else {
         if (n > 3) {
            System.out.print("[");
            System.out.print("(");
            printPattern(n - 4);
            System.out.print("]");
            System.out.print(")");
         }else {
            System.out.print("(");
            printPattern(n - 2);
            System.out.print(")");
         }
      }
   }
   public static void printTwos(int n) {
      if (n % 2 != 0) {
         System.out.print(n);
      }else {
         if (n % 4 == 0) {
            System.out.print(2 + " * ");
            printTwos(n / 4);
            System.out.print(" * " + 2);
         }else {
            System.out.print(2 + " * ");
            printTwos(n / 2);
         }
      }
   }
   public static void showSplit(int n) {
      if (n == 1 || n == 0) {
         System.out.print(n);
      }else {
         if (n == 2) {
            System.out.print("2 = (1, 1)");
         }else {
            System.out.print(n + " = (");
            showSplit(n / 2 + n % 2);
            System.out.print(", ");
            showSplit(n / 2);
            System.out.print(")");
         }
      }
   }
   public static void writeNumber(int n) {
      if (n == 1) {
         System.out.println(1);
      }else {
         if (n % 2 == 0) {
            writeNumber(n - 1);
            System.out.print(", " + n);
         }else {
            System.out.print(n + ", ");
            writeNumber(n - 1);
         }
      }
   }
}
