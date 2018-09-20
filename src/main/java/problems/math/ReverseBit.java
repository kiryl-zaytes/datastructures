package problems.math;

/**
 * Created by kiryl_zayets on 9/20/18.
 */
public class ReverseBit {

    public static int reverseBits(int n) {
        int res = 0;

        for (int i = 0; i < 32; i++) {
            res <<= 1;
            if ((n & 1) == 1) res+=1;
            n >>= 1;
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.print(ReverseBit.reverseBits(43261596));
    }

}
