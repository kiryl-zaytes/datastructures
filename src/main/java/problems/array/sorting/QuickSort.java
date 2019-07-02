package problems.array.sorting;

import java.util.Random;

/**
 * Created by kiryl_zayets on 6/25/19.
 */
public class QuickSort {


    public void sort(int[] seq, int l, int h){
        if(l >= h) return;
        int m = partition(seq, l, h);
        sort(seq, l, m - 1);
        sort(seq, m + 1, h);
    }


    private int partition(int[] seq, int l, int h){
        int lo = l;
        int hi = h+1;
        int val = seq[l];

        while (true){

            while (val >= seq[++lo]) if(lo == h) break;
            while (val < seq[--hi]) if (hi == l) break;
            if(lo >= hi) break;
            swap(seq, lo, hi);
        }
        swap(seq, l, hi);

        return hi;

    }

    private void swap(int[] seq, int l, int h){
        int b = seq[l];
        seq[l] = seq[h];
        seq[h] = b;
    }


    public static void main(String[] args){
        int[] seq = new int[]{5,2,5,6,7,2};
        Random random = new Random();
        QuickSort qs =new QuickSort();
        qs.sort(seq, 0, seq.length-1);
    }

}
