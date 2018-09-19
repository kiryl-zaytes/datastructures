package problems.other;

import java.util.Stack;

/**
 * Created by kiryl_zayets on 9/19/18.
 */
public class Parentheses {

    public static boolean isValid(String s) {
        if (s.isEmpty()) return true;
        Stack<Character> stack = new Stack();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {

                if (stack.empty()) return false;
                Character popped = stack.pop();
                if (popped == '(' && c != ')')
                    return false;
                else if (popped == '[' && c != ']')
                    return false;
                else if (popped == '{' && c != '}')
                    return false;
            }

        }
        if (!stack.empty()) return false;

        return true;


    }


    public static void main(String[] args) {
        System.out.print(Parentheses.isValid("{[]}"));
    }

}
