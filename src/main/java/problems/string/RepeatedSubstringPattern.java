package problems.string;

/**
 * Created by kiryl_zayets on 12/3/18.
 */
public class RepeatedSubstringPattern {

    public boolean repeatedSubstringPattern(String s) {
        String n = s + s;
        return n.substring(1, s.length() - 1).contains(s);
    }



    public boolean repeatedSubstringPattern1(String s) {

        int slow = 0;
        int fast = 0;
        int end = s.length() - 1;
        int l = 0;

        while (slow <= end) {

            while (fast <= end && s.charAt(fast) != s.charAt(end)) fast++;

            if (fast < end && s.charAt(fast) == s.charAt(end)) {
                fast--;
                end--;
                l++;
            } else return false;
            if (slow > fast) {
                slow = l;
                fast = l;
             //   end = s.length() - l;
            }

        }

        return true;
    }


    public static void main(String[] args) {
        RepeatedSubstringPattern rsp = new RepeatedSubstringPattern();
        System.out.print(rsp.repeatedSubstringPattern("gagagagagagaga"));
    }

}
