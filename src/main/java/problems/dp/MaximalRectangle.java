package problems.dp;

import java.util.Arrays;

/**
 * Created by kiryl_zayets on 2/4/19.
 */
public class MaximalRectangle {


    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int row = matrix.length;
        int col  = matrix[0].length;

        int[] left = new int[row];
        int[] right = new int[row];
        int[] height = new int[row];

        int res = 0;

        Arrays.fill(right, col);

        for (int i=0; i < row; i++){

            for(int j=0; j<col; j++){
                if (matrix[i][j] == '1') height[j]++;
                else height[j] = 0;
            }



            int leftSoFar = 0;

            for (int j=0; j<col;j++){
                if (matrix[i][j] == '1') left[j] = Math.max(leftSoFar, left[j]);
                else {
                    leftSoFar = j+1;
                    left[j]=0;
                }
            }

            int rightSoFar = col;

            for (int j=col; j <=0; j--){
                if (matrix[i][j] == '1') right[j] = Math.min(rightSoFar, right[j]);
                else {
                    rightSoFar = j;
                    right[j] = col;
                }
            }


            for(int j=0; j < col; j++){
                res = Math.max(res, (right[j] - right[i])*height[j]);
            }

        }

        return res;
    }

}
