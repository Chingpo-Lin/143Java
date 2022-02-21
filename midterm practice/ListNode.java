public class ListNode {
   public int data;
   public ListNode next;
   
   public ListNode() {
      this(0, null);
   }
   
   public ListNode(int data) {
      this.data = data;
      next = null;
   }
   
   public ListNode(int data, ListNode next) {
      this.data = data;
      this.next = next;
   }
   
   public String toString() {
      String temp = "";
      int temp2 = data;
      ListNode tempNext = new ListNode(data, next);
      while (tempNext.next != null) {
         temp += temp2;
         tempNext = tempNext.next;
         temp2 = tempNext.data;
      }
      temp += tempNext.data;
      return temp;
   }
}  