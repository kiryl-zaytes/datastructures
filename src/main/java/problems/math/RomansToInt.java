package problems.math;

import java.util.HashMap;

/**
 * Created by kiryl_zayets on 9/20/18.
 */
public class RomansToInt {

    public static int romanToInt(String s) {
        HashMap<String, Integer> vocab = new HashMap<String, Integer>();
        vocab.put("IV", 4);
        vocab.put("IX", 9);
        vocab.put("XL", 40);
        vocab.put("XC", 90);
        vocab.put("CD", 400);
        vocab.put("CM", 900);

        vocab.put("I", 1);
        vocab.put("V", 5);
        vocab.put("X", 10);
        vocab.put("L", 50);
        vocab.put("C", 100);
        vocab.put("D", 500);
        vocab.put("M", 1000);

        int total = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i == s.length()-1){
                total += vocab.get(Character.toString(s.charAt(i)));
                return total;
            }


            String k = Character.toString(s.charAt(i)) + Character.toString(s
                    .charAt(
                            i + 1));
            if (vocab.containsKey(k)) {
                total += vocab.get(k);
                i ++;
            } else {
                total += vocab.get(Character.toString(s.charAt(i)));
            }
        }
        return total;
    }


    public static void main (String[] args){
        RomansToInt.romanToInt("I");
    }
}
