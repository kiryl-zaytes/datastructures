package problems.backtracking;

/**
 * Created by kiryl_zayets on 10/1/18.
 */
public class StartHere {

    int N = 3;
    int[] a = new int[N];

    public void print() {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");

        }
        System.out.println();
    }


    public void enumerate(int k) {
        if (k == N) {
            print();
            return;
        }

        enumerate(k + 1);
        a[k] = 1;
        enumerate(k + 1);
        a[k] = 0;

    }

    public static void main(String[] args) {
        StartHere startHere = new StartHere();
        startHere.enumerate(0);
    }

}
