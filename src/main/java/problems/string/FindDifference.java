package problems.string;

/**
 * Created by kiryl_zayets on 11/28/18.
 */
public class FindDifference {

    public char findTheDifference(String s, String t) {
        int[] storage = new int[256];
        for(int i=0; i<s.length(); i++){
            storage[s.charAt(i)]++;
        }

        for (int j=0; j < t.length(); j++){
            storage[t.charAt(j)]--;
            if ( storage[t.charAt(j)]< 0) return t.charAt(j);
        }
       return (char) -1;
    }


    public static void main(String[] args) throws ClassNotFoundException {
        FindDifference fd = new FindDifference();
        System.out.print(fd.findTheDifference("abcd", "abcde"));
    }


}
