package problems.string;

import java.util.HashMap;

/**
 * Created by kiryl_zayets on 11/10/18.
 */
public class Isomorphic {

    HashMap<Character, Character> mapping = new HashMap<>();

    public boolean isIsomorphic2(String s, String t) {
        if (s.length() != t.length()) return false;

        for (int i = 0; i < s.length(); i++) {
            Character a = s.charAt(i);
            Character b = t.charAt(i);
            if (mapping.containsKey(a)) {
                if (mapping.get(a) != b) return false;
            }
            else{
                if (!mapping.containsValue(b)) mapping.put(s.charAt(i), t.charAt(i));
                else return false;
            }
        }

        return true;
    }


    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Integer> ms = new HashMap<>();
        HashMap<Character, Integer> mt = new HashMap<>();


        for (int i=0; i< s.length();i++){

            int ps = ms.getOrDefault(s.charAt(i), -1);
            int pt = ms.getOrDefault(t.charAt(i), -1);

            if (ps!=pt) return false;

            ms.put(s.charAt(i), i);
            mt.put(s.charAt(i), i);

        }
        return true;
    }



    public static void main(String[] args) {
        Isomorphic is = new Isomorphic();
        System.out.print(is.isIsomorphic("paper", "title"));
    }

}
