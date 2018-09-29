package problems.array.matrix;

/**
 * Created by kiryl_zayets on 9/28/18.
 */
public class NumOfIslands {


    public static int numIslands(char[][] grid) {
        int count = 0;

        int r = grid.length;
        int c = grid[0].length;

        if (r == 0) return 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == '1') {
                    helper(grid, i, j, r, c);
                    count++;
                }

            }
        }

        return count;

    }


    public static void helper(char[][] grid, int i, int j, int r, int c) {
        if ((i < 0 || i >= r) || (j < 0 || j >= c) || (grid[i][j] == '0'))
            return;

        grid[i][j] = '0';

        helper(grid, i - 1, j, r, c);
        helper(grid, i + 1, j, r, c);
        helper(grid, i, j - 1, r, c);
        helper(grid, i, j + 1, r, c);

    }


    public static void main(String[] args) {


        NumOfIslands.numIslands(new char[][]{
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}});

    }

}
