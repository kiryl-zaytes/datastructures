package problems.array;

import java.util.HashMap;

/**
 * Created by kiryl_zayets on 2/11/19.
 */
public class TotalFruit {

    public int totalFruit(int[] tree) {

        HashMap<Integer, Integer> storage = new HashMap<>();

        int max = 0;

        int startPos = 0;

        for (int i=0; i < tree.length; i++){
            storage.put(tree[i], storage.getOrDefault(tree[i], 0) + 1);

            while (storage.size() > 2){
                storage.put(tree[startPos], storage.get(tree[startPos]) - 1);
                if (storage.get(tree[startPos]) == 0) storage.remove(tree[startPos]);
                startPos++;
            }

            max = Math.max(max, i - startPos + 1);

        }
        return max;
    }


    public static void main(String[] args){
        TotalFruit tf = new TotalFruit();
        tf.totalFruit(new int[]{3,3,3,1,3,3,3,2});
    }

}
