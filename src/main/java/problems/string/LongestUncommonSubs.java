package problems.string;

/**
 * Created by kiryl_zayets on 12/5/18.
 */
public class LongestUncommonSubs {

    public int findLUSlength(String a, String b) {
        int[] chars = new int[256];

        for (int i = 0; i < a.length(); i++) chars[a.charAt(i)]++;

        int l = 0;
        int foundMax = 0;
        for (int i=0; i<b.length(); i++){
            chars[b.charAt(i)]--;
            if (chars[b.charAt(i)] < 0) l++;
            else {
                foundMax = Math.max(foundMax, l);
                l = 0;
            }
        }
        foundMax = Math.max(foundMax, l);

        return (foundMax==0)? -1: foundMax;
    }


    public static void main(String[] args){
        LongestUncommonSubs lus = new LongestUncommonSubs();
        System.out.print(lus.findLUSlength("aba", "cdc"));
    }


}
