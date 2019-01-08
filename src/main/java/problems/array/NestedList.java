package problems.array;

import java.util.List;

/**
 * Created by kiryl_zayets on 12/20/18.
 */
public class NestedList {

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


    public int depthSum(List<NestedInteger> nestedList) {
       return helper(nestedList, 1);
    }

    private int helper(List<NestedInteger> nested, int lvl) {
        int sum = 0;
        for (NestedInteger list : nested) {
            if (list.isInteger()) sum += list.getInteger() * lvl;
            else sum += helper(list.getList(), lvl + 1);
        }
        return sum;
    }
}
