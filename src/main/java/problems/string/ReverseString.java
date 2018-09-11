package problems.string;

/**
 * Created by kiryl_zayets on 9/11/18.
 */
public class ReverseString {

    public static String reverseString(String s) {
        if (s.length() < 1) return s;
        StringBuffer stringBuffer = new StringBuffer();

        for (int i = s.length() - 1; i >= 0; i--) {
            stringBuffer.append(s.charAt(i));
        }

        return stringBuffer.toString();
    }


    public static void main(String[] args) {
        ReverseString.reverseString("hello");
    }

}
