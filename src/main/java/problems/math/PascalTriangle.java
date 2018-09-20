package problems.math;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kiryl_zayets on 9/20/18.
 */
public class PascalTriangle {


//    public List<List<Integer>> generate(int numRows) {
//
//    }


    public static List<List<Integer>> generate(int n) {
        ArrayList<List<Integer>> storage = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    tmp.add(1);
                } else {
                    tmp.add(storage.get(i - 1).get(j-1) +
                            storage.get(i - 1).get(j));
                }
            }
            storage.add(tmp);
        }
        return storage;
    }


    public static void main(String[] args) {
        PascalTriangle.generate(6);

    }

}
