package problems.array.sorting;

/**
 * Created by kiryl_zayets on 6/26/19.
 */
public class MergeSort {


    public void sort(int[] a, int[] aux, int l, int h){
        if(l >= h) return;

        int m = l+ (h-l)/2;

        sort(a, aux, l, m);
        sort(a, aux, m+1, h);
        merge(a, aux, l, h, m);

    }

    private void merge(int[] a, int[]aux, int l, int h, int mid) {

        for(int i=l; i <=h; i++) aux[i] = a[i];
        int i = l;
        int j = mid+1;

        int k = l;
        while(i < j){
            if(i > mid) a[k++] = aux[j++];
            else if(j >= h) a[k++] = aux[i++];
            else if (aux[i] < aux[j]) a[k++] = aux[i++];
            else a[k++] = aux[j++];
        }

    }

}
