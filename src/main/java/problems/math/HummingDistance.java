package problems.math;

/**
 * Created by kiryl_zayets on 9/20/18.
 */
public class HummingDistance {

    public static int hammingDistance(int x, int y) {
        int res = x^y;
        int count = 0;
        for (int i=0; i < 32;i++){

            count+=(res>>i) & 1;
        }
        return count;

    }


    public static void main(String[] args) {


        System.out.print(HummingDistance.hammingDistance(1, 4));

    }


}
