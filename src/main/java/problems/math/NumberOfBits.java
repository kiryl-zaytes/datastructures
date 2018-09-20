package problems.math;

/**
 * Created by kiryl_zayets on 9/20/18.
 */
public class NumberOfBits {

    public static int hammingWeight(int n) {
        int res = 0;

        for(int i=0; i < 32;i++){
            res+=(n>>i) & 1;
        }

        return res;
    }

    public static void main(String[] args) {


        System.out.print(NumberOfBits.hammingWeight(128));

    }

}
