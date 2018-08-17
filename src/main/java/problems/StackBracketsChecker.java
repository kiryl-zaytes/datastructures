package problems;

import datastructures.stack._StackList;

import java.util.HashMap;

/**
 * Should return true for [()]{}{[()()]()} and false for [(])
 */
public class StackBracketsChecker {

    public static boolean checkBrackets(String exp){
        HashMap<Character, Character> kv = new HashMap<Character, Character>();
        _StackList<Character> stackList = new _StackList<Character>();

        kv.put('(', ')');
        kv.put('[', ']');
        kv.put('{', '}');

        for(int i=0; i<exp.length(); i++){
            if ("([{".indexOf(exp.charAt(i)) > -1) stackList.push(exp.charAt(i));
            else {
                Character val = stackList.pop();
                if (exp.charAt(i) != kv.get(val)){
                    return false;
                }
            }
        }

        return true;
    }


    public static void main(String[] args){
        boolean res = StackBracketsChecker.checkBrackets("[()]{}{[()()]()}");
        boolean res2 = StackBracketsChecker.checkBrackets("[(])");
        System.out.print(res);
        System.out.print(res2);
    }
}
