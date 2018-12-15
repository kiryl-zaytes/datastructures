package problems.string;

/**
 * Created by kiryl_zayets on 12/11/18.
 */
public class PalindromicSubstrings {

    public int countSubstrings(String s) {

        if (s == null || s.length() == 0 ) return 0;
        int count = 0;
        for(int i=0; i < s.length(); i++){
            count+=getPoly(s, i, i);
            count+=getPoly(s, i, i+1);
        }
        return count;

    }

    private int getPoly(String str, int s, int e){
        int c = 0;
        while (s >=0 && e < str.length() && str.charAt(s) == str.charAt(e)){
            c++;
            s--;
            e++;
        }
        return c;
    }

}
