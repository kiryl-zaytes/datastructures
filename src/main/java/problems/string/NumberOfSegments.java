package problems.string;

/**
 * Created by kiryl_zayets on 11/29/18.
 */
public class NumberOfSegments {

    public int countSegments(String s) {
        int count = 0;
        for (int i=0; i<s.length(); i++){
            while (i < s.length() && s.charAt(i) == ' ') i++;
            if (i < s.length() && s.charAt(i) != ' ') count++;
            while (i < s.length() && s.charAt(i) != ' ') i++;
        }
        return count;

    }


    public static void main(String[] args){
        NumberOfSegments nos = new NumberOfSegments();
        System.out.print(nos.countSegments(" 3 "));
    }


}
