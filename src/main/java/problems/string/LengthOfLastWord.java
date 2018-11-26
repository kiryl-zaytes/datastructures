package problems.string;

/**
 * Created by kiryl_zayets on 11/22/18.
 */
public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        if (s.length() == 0) return 0;
        int h = s.length()-1;
        while (h>=0 && s.charAt(h) == ' ') h--;
        int res = 0;
        while (h >= 0 && s.charAt(h) != ' '){
            h--;
            res++;
        }
        return res;
    }

    public static void main(String[] args){
        LengthOfLastWord low = new LengthOfLastWord();
        System.out.print(low.lengthOfLastWord(""));
    }


}
