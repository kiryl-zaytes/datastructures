package problems.array.matrix;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by kiryl_zayets on 2/22/19.
 */
public class DiagonalTraverse {


    public int[] findDiagonalOrder(int[][] matrix) {

        if (matrix == null || matrix.length == 0) return new int[0];

        int M = matrix.length;
        int N = matrix[0].length;

        int[] res = new int[M * N];

        int row = 0, col = 0;

        for (int i = 0; i < res.length; i++) {
            res[i] = matrix[row][col];

            if ((row + col) % 2 == 0) {

                if (row == 0 || row == M - 1) col += 1;
                else if (col == 0 || col == N - 1) row += 1;
                else {
                    row -= 1;
                    col += 1;
                }
            } else {

                if (row == 0 || col == N-1) {
                    row -= 1;
                    col -= 1;
                }
                else if (row == M - 1) col += 1;
                else {
                    row += 1;
                    col -= 1;
                }
            }
        }
        PriorityQueue<Integer[]> q = new PriorityQueue<>(new Comparator<Integer[]>() {

            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return 0;
            }

        });



        return res;
    }
}
