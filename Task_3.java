package HW_Java_3;

import java.util.ArrayList;
import java.util.List;

public class Task_3 {
   static List<Character> array;
   static List<Integer> index_num;

   public static void main(String[] args) {
      String equationNew = "2? + ?5 = 69".replace(" ", "");
      array = new ArrayList<>();
      index_num = new ArrayList<>();

      for (int i = 0; i < equationNew.length(); i++) {
         array.add(equationNew.charAt(i));
         if (array.get(i) == '?') {
            index_num.add(i);
         }
      }

      creatingCombination(0, new ArrayList<>(), 9, index_num.size());
   }

   private static void creatingCombination(int prev, List<Integer> comb, int n, int k) {
      if (comb.size() == k) {
         // System.out.println(comb.toString());
         equationResult(comb);
         return;
      }
      if (comb.size() == k - 1) {
         prev = 0;
      }
      for (int i = prev; i <= n; i++) {
         comb.add(i);
         creatingCombination(i, comb, n, k);
         comb.remove(comb.size() - 1);
      }
   }

   private static void equationResult(List<Integer> comb) {
      String result = "";
      for (int i = 0; i < comb.size(); i++) {
         char x = Integer.toString(comb.get(i)).charAt(0);
         array.set(index_num.get(i), x);
      }
      for (int i = 0; i < array.size(); i++) {
         if (array.get(i) == '+') {
            result += '=';
         } else {
            result += array.get(i);
         }
      }
      String[] arr = result.split("=");
      int sum = 0;
      int res = Integer.parseInt(arr[arr.length - 1]);
      for (int i = 0; i < arr.length - 1; i++) {
         sum += Integer.parseInt(arr[i]);
      }
      if (sum == res) {
         System.out.printf("Вариант уравнения %s + %s = %s верно\n", arr[0], arr[1], res);
      }

   }
}
