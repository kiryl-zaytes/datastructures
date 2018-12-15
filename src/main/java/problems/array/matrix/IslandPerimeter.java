package problems.array.matrix;

/**
 * Created by kiryl_zayets on 12/3/18.
 */
public class IslandPerimeter {
    public int islandPerimeter1(int[][] grid) {
        int land = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    land += 4;
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) land -= 2;
                    if (j < grid[i].length - 1 && grid[i][j + 1] == 1) land -= 2;
                }
            }
        }

        return land;
    }
    public int islandPerimeter(int[][] grid) {
        int land = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    return helper(grid, i, j);
                }
            }
        }

        return land;
    }


    private int helper(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length ||
                grid[i][j] == 0) return 1;

        if (grid[i][j] == -1) return 0;
        int count = 0;
        grid[i][j] = -1;
        count+=helper(grid, i + 1, j);
        count+=helper(grid, i - 1, j);
        count+=helper(grid, i, j + 1);
        count+=helper(grid, i, j - 1);
        return count;
    }
}
