package problems.array;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by kiryl_zayets on 12/4/18.
 */
public class NextGreaterElement {

    public int[] nextGreaterElement(int[] look, int[] given) {
        HashMap<Integer, Integer> storage = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int e : given) {
            while (!stack.empty() && stack.peek() < e) {
                storage.put(stack.pop(), e);
            }
            stack.push(e);
        }

        for (int i = 0; i < look.length; i++) {
            look[i] = storage.getOrDefault(look[i], -1);
        }
        return look;
    }

    public static void main(String[] args){

        NextGreaterElement nge = new NextGreaterElement();
        nge.nextGreaterElement(new int[]{4,1,2}, new int[]{1,3,4,2});
    }


}
