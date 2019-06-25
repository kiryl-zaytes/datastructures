package problems.string;

import java.util.Stack;

/**
 * Created by kiryl_zayets on 6/5/19.
 */
public class Calculate {

    public int calculate(String s) {

        int n = 0;
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        for(int i=0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c>='0' && c <='9'){
                n=n*10 + (c-'0');
            }

            if ((!Character.isDigit(c) && c !=' ')|| i == s.length()-1){
                if (sign == '*') stack.push(stack.pop() * n);
                else if (sign == '/') stack.push(stack.pop()/n);
                else if (sign == '+') stack.push(n);
                else stack.push(-n);
                sign = s.charAt(i);
                n = 0;
            }


        }


        int res = 0;
        while(!stack.isEmpty()) res+=stack.pop();

        return res;
    }


    public static void main(String[] args){
        Calculate calc = new Calculate();
        calc.calculate("3+2*2");
    }

}
