package HW_Java_3;

import java.util.ArrayList;
import java.util.List;

public class Task_3 {
   static List<Integer> index_num;
   static char[] array;

   public static void main(String[] args) {
      String equationNew = "2? + ?5 = 69".replace(" ", "");
      index_num = new ArrayList<>();
      array = equationNew.toCharArray();

      for (int i = 0; i < array.length; i++) {
         if (array[i] == '?') {
            index_num.add(i);
         }
      }
      creatingCombination(new ArrayList<>(), 9, index_num.size());
   }

   private static void creatingCombination(List<Integer> comb, int n, int k) {
      if (comb.size() == k) {
         equationResult(comb);
         return;
      }
      for (int i = 0; i <= n; i++) {
         comb.add(i);
         creatingCombination(comb, n, k);
         comb.remove(comb.size() - 1);
      }
   }

   private static void equationResult(List<Integer> comb) {
      String result = "";
      for (int i = 0; i < comb.size(); i++) {
         char x = Integer.toString(comb.get(i)).charAt(0);
         array[index_num.get(i)] = x;
      }
      for (int i = 0; i < array.length; i++) {
         if (array[i] == '+') {
            result += '=';
         } else {
            result += array[i];
         }
      }
      String[] arr = result.split("=");
      int sum = 0;
      int res = Integer.parseInt(arr[arr.length - 1]);
      for (int i = 0; i < arr.length - 1; i++) {
         sum += Integer.parseInt(arr[i]);
      }
      if (sum == res) {
         System.out.printf("Вариант уравнения %s + %s = %s верно\n", arr[0], arr[1],
               res);
      }

   }
}
