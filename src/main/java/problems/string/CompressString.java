package problems.string;

/**
 * Created by kiryl_zayets on 11/30/18.
 */
public class CompressString {


    public int compress(char[] chars) {
        if (chars.length == 0) return 0;

        int start = 0;
        int counter = 1;


        for (int i = 1; i < chars.length + 1; i++) {
            if (i < chars.length && chars[i] == chars[i - 1]) {
                counter++;
                continue;
            }
            if (counter > 1) {
                chars[start++] = chars[i - 1];
                String tmp = String.valueOf(counter);
                for (int j = 0; j < tmp.length(); j++)
                    chars[start++] = tmp.charAt(j);
                counter = 1;
            } else {
                chars[start] = chars[i-1];
                start++;
            }
        }
        return start;
    }


    public static void main(String[] args) {
        CompressString cs = new CompressString();
        System.out.print(cs.compress(new char[]{'a', 'a', 'a', 'a', 'a', 'b'}));
    }

}
