package problems.array.matrix;

/**
 * Created by kiryl_zayets on 2/19/19.
 */
public class MaxAreaOfIsland {


    int max = 0;

    public int maxAreaOfIsland(int[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    int res = move(i, j, grid);
                    max = Math.max(res, max);
                }
            }

        }
        return max;
    }


    private int move(int i, int j, int[][] grid) {

        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length ||
                grid[i][j] == 0) return 0;
        grid[i][j] = 0;
        int u = move(i - 1, j, grid);
        int d = move(i + 1, j, grid);
        int l = move(i, j - 1, grid);
        int r = move(i, j + 1, grid);

        return 1 + u + d + l + r;

    }


    public static void main(String[] args){
        MaxAreaOfIsland maxAreaOfIsland = new MaxAreaOfIsland();
        int r= maxAreaOfIsland.maxAreaOfIsland(new int[][]{
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0} });
        System.out.print(r);

    }

}
