package problems.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 */
public class SpiralOrder {


    public static List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (matrix.length == 0) return res;

        int row = matrix.length;
        int col = matrix[0].length;
        int size = row * col;

        int repeat = (int) Math.ceil((double) (row * col) / (row+col));

        int i = 0;
        int j = 0;
        int k = col - 1;
        int h = row - 1;
        int total = 0;

        for (int l = 0; l < repeat; l++) {

            while (i < col & total != size) {
                res.add(matrix[l][i++]);
                total++;
            }

            i = l+1;

            if (total == size) break;

            j = l+1;
            while (j < row & total != size) {
                res.add(matrix[j++][col - 1]);
                total++;
            }
            j = i+1;
            if (total == size) break;

            while (k > l) {
                res.add(matrix[row - 1][k - 1]);
                k--;
                total++;
            }

            while (h > l + 1) {
                res.add(matrix[h - 1][l]);
                h--;
                total++;
            }

            row = row - 1;
            col = col - 1;
            k = col - 1;
            h = row - 1;
        }

        return res;
    }


    public static void main(String[] args) {

        int[][] matrx = new int[5][5];
        int c = 1;
        for (int i = 0; i < matrx.length; i++) {

            for (int j = 0; j < matrx[0].length; j++) {
                matrx[i][j] = c;
                c++;
            }
        }

        ArrayList res = (ArrayList) SpiralOrder.spiralOrder(matrx);
        System.out.println(res);
    }
}
