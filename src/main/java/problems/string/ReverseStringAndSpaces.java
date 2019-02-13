package problems.string;

/**
 * Created by kiryl_zayets on 2/13/19.
 */
public class ReverseStringAndSpaces {

    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return s;
        int start = 0;
        int end = s.length()-1;
        StringBuilder sb = new StringBuilder();

        while (start < s.length() && s.charAt(start) == ' ') start++;
        while (end >=0 && s.charAt(end) == ' ') end--;

        for(int i = end; i>=start; i-- ) sb.append(s.charAt(i));

        start = 0;

        for(int i=0; i<= sb.length(); i++){

            if (i == sb.length()|| sb.charAt(i)==' ') {
                int border = (i - start)/2;
                for(int ss = i-1; ss >= i-border; ss--){
                    char temp = sb.charAt(start);
                    sb.setCharAt(start, sb.charAt(ss));
                    sb.setCharAt(ss, temp);
                    start++;
                }
                while (i < sb.length()-1 && sb.charAt(i+1) == ' ') {
                    sb.deleteCharAt(i+1);
                }
                start = i+1;
            }

        }
        return sb.toString();
    }

    public static void main(String[] args){
        ReverseStringAndSpaces rs = new ReverseStringAndSpaces();
        rs.reverseWords(" ");

    }

}
