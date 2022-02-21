public class ArrayIntListMain {
   public static void main(String[] args) {
      ArrayIntList list1 = new ArrayIntList();
      ArrayIntList list2 = new ArrayIntList();
      list1.add(1);
      list1.add(2);
      list1.add(3);
      list1.add(4);
      list1.add(0);
      list1.add(19);
      list1.add(1);
      list1.add(1);
      list1.add(2);
      list1.add(2);
      list1.add(3);
      list1.add(3);
      System.out.println(list1);
      System.out.println(list1.longestSortedSequence());
   }
}