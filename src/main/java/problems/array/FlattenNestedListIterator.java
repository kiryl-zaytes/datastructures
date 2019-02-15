package problems.array;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by kiryl_zayets on 2/14/19.
 */
public class FlattenNestedListIterator implements Iterator<Integer> {

    List<Integer> flatten;
    int N = 0;
    int current = 0;

    public FlattenNestedListIterator(List<NestedList.NestedInteger> nestedList) {
        flatten = new ArrayList<>();
    }


    private void rec(List<NestedList.NestedInteger> storage){
        if (storage == null || storage.size() == 0) return;
        for(NestedList.NestedInteger nestedInteger: storage){
            if (nestedInteger.isInteger()) {
                flatten.add(nestedInteger.getInteger());
                N++;
            }
            rec(nestedInteger.getList());
        }
    }

    @Override
    public Integer next() {
        Integer cur = null;
        if (hasNext()) {
            cur = flatten.get(current++);
            N--;
        }
        return cur;

    }

    @Override
    public boolean hasNext() {
        return N != 0;
    }
}
