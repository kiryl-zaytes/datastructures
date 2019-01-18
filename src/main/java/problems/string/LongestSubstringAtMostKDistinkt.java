package problems.string;

/**
 * Created by kiryl_zayets on 1/16/19.
 */
public class LongestSubstringAtMostKDistinkt {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {

        int[] alph  = new int[256];

        int unique = 0;
        int tail = 0;
        int max = 0;

        for (int i=0; i < s.length(); i++){
            if (alph[s.charAt(i)] == 0) unique++;
            alph[s.charAt(i)]++;

            while (unique > k){
                alph[s.charAt(tail)]--;
                if (alph[s.charAt(tail)] == 0) unique--;
                tail++;
            }
           max = Math.max(max,  i - tail+1);
        }

        return max;

    }


    public static void main(String[] args){

        LongestSubstringAtMostKDistinkt ls = new LongestSubstringAtMostKDistinkt();
        ls.lengthOfLongestSubstringKDistinct("bacc", 2);

    }



}
