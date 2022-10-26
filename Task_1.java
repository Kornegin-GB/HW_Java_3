package HW_Java_3;

public class Task_1 {
   public static void main(String[] args) {
      char[][] grid = {
            { '1', '1', '1', '1', '0' },
            { '1', '1', '0', '1', '0' },
            { '1', '1', '0', '0', '0' },
            { '0', '0', '0', '0', '0' }
      };
      System.out.println(numIslands(grid));

      char[][] grid_1 = {
            { '1', '1', '0', '0', '0' },
            { '1', '1', '0', '0', '0' },
            { '0', '0', '1', '0', '0' },
            { '0', '0', '0', '1', '1' }
      };
      System.out.println(numIslands(grid_1));
   }

   private static int numIslands(char[][] grid) {
      int islands = 0;
      for (int i = 0; i < grid.length; i++) {
         for (int j = 0; j < grid[0].length; j++) {
            if (grid[i][j] == '1') {
               islands++;
               calculatedArea(i, j, grid);
            }
         }
      }
      return islands;
   }

   private static int calculatedArea(int i, int j, char[][] grid) {
      if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
         return 0;
      }
      grid[i][j] = '0'; // Для того чтобы не повторялся подсчет
      return 1 + calculatedArea(i - 1, j, grid) + calculatedArea(i, j - 1, grid) + calculatedArea(i + 1, j, grid)
            + calculatedArea(i, j + 1, grid);
   }
}
