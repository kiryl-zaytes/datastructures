package problems.array.matrix;

import java.util.HashSet;

/**
 * Created by kiryl_zayets on 2/21/19.
 */
public class NumberOfDistinctNumbers {


    public int numDistinctIslands(int[][] grid) {
        HashSet<String> res = new HashSet<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    walker(grid, i, j, sb, "");
                    res.add(sb.toString());
                }
            }
        }

        return res.size();
    }


    private void walker(int[][] grid,
            int i,
            int j,
            StringBuilder sb,
            String dir) {

        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length ||
                grid[i][j] == 0) return;
        sb.append(dir);
        grid[i][j] = 0;
        walker(grid, i, j - 1, sb, "l");
        walker(grid, i, j + 1, sb, "r");
        walker(grid, i - 1, j, sb, "u");
        walker(grid, i + 1, j, sb, "d");
        sb.append("b");
    }


    public static void main(String[] args) {
        NumberOfDistinctNumbers maxAreaOfIsland = new NumberOfDistinctNumbers();
        int r = maxAreaOfIsland.numDistinctIslands(new int[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1}
        });
        System.out.print(r);

    }

}
