package problems.string;

/**
 * Created by kiryl_zayets on 2/25/19.
 */
public class OneEditDistance {


    public boolean isOneEditDistance(String s, String t) {
        if (s.length() - t.length() > 1) return false;
        if (t.length() < s.length())return isOneEditDistance(t, s);

        for (int i=0; i < s.length(); i++){
            if (s.charAt(i) != t.charAt(i)){
                if (s.length() == t.length()) return s.substring(i+1).equals(t.substring(i+1));
                else return s.substring(i).equals(t.substring(i+1));
            }
        }

        return s.length()+1 == t.length();
    }


    public static void main(String[] args){
        OneEditDistance oed = new OneEditDistance();
        System.out.print(oed.isOneEditDistance("a", ""));
    }

}
