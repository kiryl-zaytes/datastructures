package problems.sorting;

/**
 * Selection sort, find min each iteration and put it at the begging and dont scan
 * again.
 */
public class Selection {

    public static Comparable[] sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j].compareTo(a[min]) < 0) {
                    min = j;
                }
            }
            Comparable tmp = a[i];
            a[i] = a[min];
            a[min] = tmp;
        }
        return a;
    }


    public static void main(String[] args){
        Integer[] x = new Integer[]{3,2,4,3,1};
        System.out.print(Selection.sort(x));
    }


}
