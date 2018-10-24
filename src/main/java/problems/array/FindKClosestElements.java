package problems.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kiryl_zayets on 10/19/18.
 */
public class FindKClosestElements {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        ArrayList arrayList= new ArrayList<>();
        int l = 0;
        int h = arr.length - k;


        while (l < h){

            int m = l + (h-l)/2;

            if (x - arr[m] > arr[m+k]-x) l = m+1;
            else h = m;
        }

        for (int i=l; i < h+k; i++){
            arrayList.add(arr[i]);
        }

        return arrayList;
    }

    private int helper(int l, int h, int[] arr, int target) {
        if (l >= h) return l;
        int m = l + (h - l) / 2;
        if (target < arr[m]) return helper(l, m - 1, arr, target);
        else if (target > arr[m]) return helper(m + 1, h, arr, target);
        else return m;
    }


    public static void main(String[] args) {
        FindKClosestElements findKClosestElements = new FindKClosestElements();
        findKClosestElements.findClosestElements(new int[]{1,2,3,4,5}, 4, 3);
    }

}
