package problems.array;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.
 * To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500.
 */
public class FourSumCount {

    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if ((A.length == 0) || (B.length == 0) || (C.length == 0) ||
                (D.length == 0)) return 0;

        int outcome = 0;

        HashMap<Integer, Integer> storage = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> storage2 = new HashMap<Integer, Integer>();

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int val = A[i] + B[j];
                int val2 = C[i] + D[j];

                if (storage.containsKey(val)){
                    Integer key = storage.get(val);
                    storage.put(val, ++key);
                }
                else storage.put(val, 1);

                if (storage2.containsKey(val2)){
                    Integer key = storage2.get(val2);
                    storage2.put(val2, ++key);
                }
                else storage2.put(val2, 1);
            }
        }

        Iterator<Map.Entry<Integer, Integer>> it = storage2.entrySet().iterator();

        while (it.hasNext()){
            Map.Entry<Integer, Integer> pair = it.next();
            Integer k = pair.getKey();
            Integer found = storage.remove(-k);
            if (found != null) {
                Integer x = pair.getValue() * found;
                outcome+=x;
            }
        }
        return outcome;
    }


    public static void main(String[] args) {
        int r = FourSumCount.fourSumCount(new int[]{-1,1,1,1,-1}, new int[]{0,-1,-1,0,1}, new int[]{-1,-1,1,-1,-1}, new int[]{0,1,0,-1,-1});
        System.out.print(r);
    }
}
