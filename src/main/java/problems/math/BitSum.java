package problems.math;

/**
 *exclusive or (***^***) handles these cases: 1+0 and 0+1
 AND (***&***) handles this case: 1+1, where carry occurs, in this case, we'll have to shift carry to the left, why?
 Think about this example: 001 + 101 = 110 (binary format), the least significant digits of the two operands are both '1', thus trigger a carry = 1,
 with this carry, their least significant digits: 1+1 = 0, thus we need to shift the carry to the left by 1 bit in order to get their correct sum: 2
 */
public class BitSum {

    public int getSum(int a , int b){
        if (b==0) return a;
        int carry = (a & b) << 1;
        int sum = a ^ b;
        return getSum(sum, carry);
    }

}
