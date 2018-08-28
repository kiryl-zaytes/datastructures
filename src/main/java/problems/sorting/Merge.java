package problems.sorting;

/**
 * Created by kiryl_zayets on 8/24/18.
 */
public class Merge {


    public static void sort(int[] a, int[] aux, int l, int h) {

        if (l >= h) {
            return;
        }

        int m = l + (h - l) / 2;

        sort(a, aux, l, m);
        sort(a, aux, m + 1, h);
        merge(a, aux, l, m, h);
    }


    public static void merge(int[] a, int[] aux, int l, int m, int h) {
        for (int i = l; i <= h; i++) {
            aux[i] = a[i];
        }

        int mid = m + 1;
        int low = l;

        for (int k = l; k <= h; k++) {
            if (low > m) a[k] = aux[mid++];
            else if (mid > h) a[k] = aux[low++];
            else if (aux[low] < aux[mid]) a[k] = aux[low++];
            else a[k] = aux[mid++];
        }
    }

    public static void main(String[] args) {

        int[] a = new int[]{3, 4, 5, 6, 7, 8, 90, 0, 1};
        int[] aux = new int[a.length];
        sort(a, aux, 0, 8);
        System.out.println(a);
    }
}
