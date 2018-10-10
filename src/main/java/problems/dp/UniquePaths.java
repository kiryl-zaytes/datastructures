package problems.dp;

/**
 * AS there is only two possible movements right or down we can init all borders
 * cells where i=0 or j=0 to 1 as there is only one possibility to reach out those cells.
 *  all other cell we calculate based of those border numbers (you can get to the cell only from left
 *  ot from up so sum up val from i-1 with j-1 and set it to next cell)
 */
public class UniquePaths {

    public int uniquePaths(int m, int n) {
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) matrix[i][j] = 1;
                else matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
            }
        }
        return matrix[m - 1][n - 1];
    }


    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        System.out.print(uniquePaths.uniquePaths(7, 3));

    }
}
