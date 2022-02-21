

public class ArrayIntList {
    private int[] elementData; // list of integers
    private int size;          // current number of elements in the list

    public static final int DEFAULT_CAPACITY = 100;
    public ArrayIntList() {
        this(DEFAULT_CAPACITY);
    }
    public ArrayIntList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("capacity: " + capacity);
        }
        elementData = new int[capacity];
        size = 0;
   }
    public String toString() {
        if (size == 0) {
            return "[]";
        } else {
            String result = "[" + elementData[0];
            for (int i = 1; i < size; i++) {
                result += ", " + elementData[i];
            }
            result += "]";
            return result;
        }
    }
     public void add(int value) {
        elementData[size] = value;
        size++;
    }
    public void collapse() {
      for (int i = 0; i < size; i ++) {
         elementData[i] = elementData[i] + elementData[i + 1];
         for (int j = i + 1; j < size; j++) {
            elementData[j] = elementData[j + 1];
         }
         if (i != size - 1) {  
            size--;
         }
      }
    }
   public void printInversions() {
      for (int i = 0; i < size - 1; i++) {
         for (int j = i + 1; j < size; j++) {
            if (elementData[i] > elementData[j])  {
               System.out.println("(" + elementData[i] + ", " + elementData[j] + ")");
            }
         }
      }
   
   }
   public void removeAll(int n) {
      for (int i = 0; i < size; i++) {
         if (elementData[i] == n) {
             for (int j = i; j < size; j++) {
                 elementData[j] = elementData[j + 1];
             }
             i--;
             size--;
         }
      }
   }
   public int maxCount() {
      int max = 0;
      for (int i = 0; i < size; i++) {
         int tempMax = 1;
         int temp = elementData[i];
         for (int j = i + 1; j < size; j++) {
            if (temp == elementData[j]) {
               tempMax++;
               i++;
            }
        }
        if (tempMax > max) {
           max = tempMax;   
        }
     }
     return max; 
   }
   public void mirror() {
      int temp = size;
      for (int i = 0; i < temp; i++) {
         elementData[temp * 2 - 1 - i] = elementData[i];
          size++;
      }
   }
   public void stretch(int n) {
      if (n == 0) {
         size = 0;   
      }
      int temp = size;
      for (int i = 0; i < temp; i++) {
          for (int j = 1; j < n; j++) {
              for (int k = size - 1; k >= i * n; k--) {
                 elementData[k + 1] = elementData[k];  
              }
              
              elementData[i * n + j] = elementData[i * n];
              size++;
          }
      }
   }
   public int longestSortedSequence() {
      int count = 1;
      int max = 1;
      if (size == 0) {
         return 0;   
      }
      for (int i = 0; i < size - 1; i++) {
         if (elementData[i] <= elementData[i + 1]) {
            count++;   
            if (count > max) {
               max = count;   
            }
         }else {
            count = 1;
         }
      }
      return max;
   }
}

 