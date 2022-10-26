package HW_Java_3;

import java.util.ArrayList;
import java.util.List;

public class Task_2 {
   static List<List<Integer>> lst;

   public static void main(String[] args) {
      int n = 4; // Диапозон чисел от 1 до n
      int k = 2; // длинна комбинации
      combine(n, k);
      printList();

      n = 1;
      k = 1;
      combine(n, k);
      printList();
   }

   private static List<List<Integer>> combine(int n, int k) {
      lst = new ArrayList<>();
      helper(0, new ArrayList<>(), n, k);
      return lst;
   }

   private static void helper(int prev, List<Integer> comb, int n, int k) {
      if (comb.size() == k) {
         lst.add(new ArrayList<>(comb));
         return;
      }

      for (int i = prev + 1; i <= n; i++) {
         comb.add(i);
         helper(i, comb, n, k);
         comb.remove(comb.size() - 1);
      }
   }

   private static void printList() {
      System.out.print("[ ");
      for (List<Integer> list : lst) {
         System.out.print(list + " ");
      }
      System.out.print("]");
      System.out.println();
   }
}
