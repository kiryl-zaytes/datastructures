package problems.string;

import java.util.Stack;

/**
 * Very limited expression could be calculated.
 * Pay attention to:
 * a. conversion from char to double: (double) Character.digit(exp.charAt(i), 10).
 * b. order of operations in (-, /)
 * c. support of num with digits > 1
 * Code left ugly intentionally!
 */
public class _String {

    public static double calculateExpression(String exp) {
        int l = exp.length();
        Stack<Character> operators = new Stack<Character>();
        Stack<Double> operands = new Stack<Double>();
        double res = 0;
        for (int i = 0; i < l; i++) {
            if (exp.charAt(i) == '+') operators.push('+');
            else if (exp.charAt(i) == '-') operators.push('-');
            else if (exp.charAt(i) == '/') operators.push('/');
            else if (exp.charAt(i) == '*') operators.push('*');
            else if (exp.charAt(i) == '(') ;
            else if (exp.charAt(i) == ')') {
                char op = operators.pop();
                if (op == '+') operands.push(operands.pop() + operands.pop());
                else if (op == '-') {
                    double sec = operands.pop();
                    double first = operands.pop();
                    operands.push(first - sec);
                } else if (op == '*')
                    operands.push(operands.pop() * operands.pop());
                else if (op == '/') {
                    double sec = operands.pop();
                    double first = operands.pop();
                    operands.push(first / sec);
                }
            } else operands.push((double) Character.digit(exp.charAt(i), 10));
        }

        while (!operators.empty()) {
            char op2 = operators.pop();
            if (op2 == '+') operands.push(operands.pop() + operands.pop());
            else if (op2 == '-') {
                double sec = operands.pop();
                double first = operands.pop();
                operands.push(first - sec);
            } else if (op2 == '*')
                operands.push(operands.pop() * operands.pop());
            else if (op2 == '/') {
                double sec = operands.pop();
                double first = operands.pop();
                operands.push(first / sec);
            }
        }

        return operands.pop();
    }

}
