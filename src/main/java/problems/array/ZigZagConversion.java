package problems.array;

import java.util.TreeMap;

/**
 * Created by kiryl_zayets on 5/17/19.
 */
public class ZigZagConversion {

    public String convert(String s, int numRows) {
        if(s == null || s.length() == 0 || numRows <= 1) return s;

        StringBuilder[]  storage = new StringBuilder[numRows];
        boolean up = false;

        for(int i=0; i < storage.length; i++) storage[i] = new StringBuilder();

        for(int  i=0; i < s.length(); i++){
            if (up) storage[storage.length - (storage.length%i) -2].append(s.charAt(i));
            else storage[i % numRows].append(s.charAt(i));
            up  = ((i + 1) % numRows == 0);
        }

        String res = "";

        for(int i=0; i < storage.length; i++) res+= storage[i].toString();


        TreeMap<Integer, String> tm = new TreeMap<>();



        return res;
    }

    public static void main(String[] args){
        ZigZagConversion zigZagConversion = new ZigZagConversion();
        zigZagConversion.convert("PAYPALISHIRING", 3);
    }

}
