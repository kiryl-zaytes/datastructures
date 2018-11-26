package problems.math;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kiryl_zayets on 11/23/18.
 */
public class PascalTriangleII {

    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);

        for(int i=1; i<=rowIndex; i++){
            for(int j = i; j >= 1; j--){
                int n = arrayList.get(j) + arrayList.get(j-1);
                arrayList.set(j, n);
            }
            arrayList.add(1);
        }
        return arrayList;
    }

}
