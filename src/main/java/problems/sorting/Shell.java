package problems.sorting;

/**
 * Created by kiryl_zayets on 8/24/18.
 */
public class Shell {


    public static Comparable[] shell(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N / 3) h = (h * 3) + 1;
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (a[j].compareTo(a[j - h]) < 0) {
                        Comparable tmp = a[j - h];
                        a[j - h] = a[j];
                        a[j] = tmp;
                    }
                }
            }
            h = h / 3;
        }
        return a;
    }

    public static void main(String[] args) {
        shell(new Integer[]{3, 4, 5, 6, 10, 7, 8, 54, 14, 455, 1, 0, 23, 34,
                1, 99});
    }

}
