package problems.math;

/**
 * Created by kiryl_zayets on 9/19/18.
 */
public class CountPrimes {


    public static int countPrimes(int n) {
        int count = 0;
        boolean[] notPrime = new boolean[n+1];

        for (int i = 2; i <= Math.sqrt(n); i++) {
            for (int j = i; j + i <= n; j = j + i) {
                if (!notPrime[i]) {
                    notPrime[j + i] = true;
                }
            }

        }

        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) {
                System.out.println(i);
                count++;
            }

        }
        return count;
    }


    public static void main(String[] args) {
        System.out.print(CountPrimes.countPrimes(3));
    }

}
