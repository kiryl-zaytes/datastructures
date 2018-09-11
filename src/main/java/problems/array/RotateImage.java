package problems.array;

/**
 * Created by kiryl_zayets on 9/10/18.
 */
public class RotateImage {

    public static void rotate(int[][] matrix) {

        if (matrix.length < 2) return;
        int iter = matrix.length - 1;
        int len = matrix.length - 1;

        int b1 = 0;
        int b2 = 0;


        for (int i = 0; i < iter / 2 + 1; i++) {

            for (int j = i; j < iter - i; j++) {

                b1 = matrix[j][len - i];
                matrix[j][len - i] = matrix[i][j];


                b2 = matrix[len - i][len - j];
                matrix[len - i][len - j] = b1;

                b1 = matrix[len - j][i];
                matrix[len - j][i] = b2;

                matrix[i][j] = b1;
            }
        }

    }


    public static void main(String[] args) {

        int[][] t = new int[2][2];
        int cnt = 1;
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                t[i][j] = cnt++;
            }
        }

        RotateImage.rotate(t);

    }

}
