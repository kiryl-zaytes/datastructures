package problems.array.matrix;

/**
 * Created by kiryl_zayets on 10/3/18.
 */
public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 ) return false;

        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (target == matrix[row][col]) return true;
            if (target < matrix[row][col]) col--;
            else if (target > matrix[row][col]) row++;
        }
        return false;
    }


    public static void main(String[] args) {
        SearchMatrix searchMatrix = new SearchMatrix();
        searchMatrix.searchMatrix(new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        }, 32);
    }

}
