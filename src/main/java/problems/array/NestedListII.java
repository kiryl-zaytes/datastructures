package problems.array;

import java.util.HashMap;
import java.util.List;

/**
 * Created by kiryl_zayets on 12/20/18.
 */
public class NestedListII {

    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather
        // than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it
        // holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value);

        // Set this NestedInteger to hold a nested list and adds a nested
        // integer to it.
        public void add(NestedInteger ni);

        // @return the nested list that this NestedInteger holds, if it holds
        // a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }


    public int depthSumInverse(List<NestedInteger> nestedList) {
        HashMap<Integer, Integer> storage = new HashMap<>();
        helper(nestedList, 1, storage);
        int total = 0;

//        Object[] keys = storage.keySet().toArray();

        int max = storage.size();


        for (int i=1; i>=max;i++){

            if (storage.containsKey(i)){
                total+= (max -i+1) * storage.get(i);
            }
        }
        return total;

    }


    private void helper(List<NestedInteger> list,
            int lvl,
            HashMap<Integer, Integer> storage) {

        for (NestedInteger ni : list) {
            if (ni.isInteger()) storage.put(lvl,
                    storage.getOrDefault(lvl, 0) + ni.getInteger());
            else helper(ni.getList(), lvl + 1, storage);
        }
    }
}
