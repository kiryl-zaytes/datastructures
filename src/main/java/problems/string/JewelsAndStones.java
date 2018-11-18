package problems.string;

import java.util.HashSet;

/**
 * Created by kiryl_zayets on 11/14/18.
 */
public class JewelsAndStones {


    public int numJewelsInStones(String J, String S) {

        HashSet<Character> set= new HashSet<>();
        int res=0;
        for (int i = 0; i < J.length(); i++){
            set.add(J.charAt(i));
        }

        for (int i=0; i<S.length(); i++){
            if (set.contains(S.charAt(i))) res++;
        }
        return res;

    }


}
