package problems.string;

/**
 * Created by kiryl_zayets on 9/11/18.
 */
public class CountAndSay {

    public static String countAndSay(int n) {
        if (n == 0) return "";
        if (n == 1) return "1";
        if (n == 2) return "11";

        String r = countAndSay(n - 1);
        int l = 0;
        int h = r.length() - 1;
        int cnt = 1;
        String r1 = "";
        while (l < h) {
            if (r.charAt(l) == r.charAt(l + 1)) {
                cnt += 1;
            } else if (r.charAt(l) != r.charAt(l + 1)) {
                r1 += String.valueOf(cnt) + r.charAt(l);
                cnt = 1;
            }

            if (r.charAt(l) != r.charAt(l + 1) && (l + 1 == h)) {
                r1 += "1" + r.charAt(l + 1);
                break;
            }
            l++;
        }

        if (cnt > 1) r1 += String.valueOf(cnt) + r.charAt(l);

        return r1;
    }


    public static void main(String[] args) {
        System.out.print(CountAndSay.countAndSay(7));
    }

}
