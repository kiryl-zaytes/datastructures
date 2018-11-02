package problems.math;

/**
 * Created by kiryl_zayets on 11/1/18.
 */
public class AddBinary {

    public String addBinary(String a, String b) {

        int res = helper(Integer.valueOf(a),Integer.valueOf(b));
        return String.valueOf(res);
        

    }


    private int helper(int a, int b) {
        if (b == 0) return a;
        int carry = (a & b) << 1;
        return helper(a ^ b, carry);
    }


    public static void main(String[] args){
        AddBinary ab = new AddBinary();

        System.out.print(ab.addBinary("11", "1"));
    }

}
