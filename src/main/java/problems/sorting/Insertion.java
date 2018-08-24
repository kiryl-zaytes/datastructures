package problems.sorting;

/**
 * Insertion sort, sort from insert back to begging.
 */
public class Insertion {

    public static Comparable[] sort(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j].compareTo(a[j - 1]) < 0) {
                    Comparable x = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = x;
                }
            }
        }
        return a;
    }

    public static void main(String[] args) {
        Integer[] x = new Integer[]{21,3, 2, 4, 3, 1, 40, 5};
        System.out.print(Insertion.sort(x));
    }

}
