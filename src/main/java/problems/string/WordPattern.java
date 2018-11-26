package problems.string;

import java.util.HashMap;

/**
 * Created by kiryl_zayets on 11/26/18.
 */
public class WordPattern {

    public boolean wordPattern(String pattern, String str) {

        HashMap<String, Integer> p = new HashMap<>();
        HashMap<String, Integer> s = new HashMap<>();

        String[] arr = str.split(" ");
        if (arr.length != pattern.length()) return false;


        for (int i=0; i<pattern.length(); i++){
            int ps = s.getOrDefault(arr[i], -1);
            int pp = p.getOrDefault(String.valueOf(pattern.charAt(i)), -1);

            if (ps != pp) return false;
            p.put(String.valueOf(pattern.charAt(i)), i);
            s.put(arr[i], i);
        }
        return true;

        
    }


    public static void main(String[] args){
        WordPattern wp = new WordPattern();
        System.out.print(wp.wordPattern("abba", "dog dog dog dog"));
    }


}
