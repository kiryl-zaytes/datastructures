package problems.string;

/**
 * Created by kiryl_zayets on 11/21/18.
 */
public class RotateString {

    public boolean rotateString(String A, String B) {

        return (A+A).contains(B);
    }


    public static void main(String[] args) {
        RotateString rs = new RotateString();
        rs.rotateString("abcde", "eabcd");
    }


}
