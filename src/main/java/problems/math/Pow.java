package problems.math;

/**
 * Created by kiryl_zayets on 10/5/18.
 */
public class Pow {



    public double myPow(double x, int n){

        if (n == 0) return 1;

        if (n < 0) {
            if (n == Integer.MIN_VALUE){
                n = - n /2;
                x= 1/(x*x);
            }
            else {
                n = -n;
                x = 1/x;
            }
        }
        if ( n % 2 == 0) return myPow(x*x, n /2);
        else return x * myPow(x*x, n/2);
    }
}
