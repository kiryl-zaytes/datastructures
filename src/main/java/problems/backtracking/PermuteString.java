package problems.backtracking;

import java.util.ArrayList;

/**
 * Created by kiryl_zayets on 2/28/19.
 */
public class PermuteString {



    public ArrayList<String> permute(String s){

        ArrayList<String> res = new ArrayList<>();
        backtrack(s, 0, s.length()-1,res);
        return res;
    }


    private void backtrack(String s, int i, int j, ArrayList<String> res){
        if ( i == j) {
            System.out.println(s);
        }

        else {
            for (int ii=i; ii<=j; ii++){
                s = swap(i, ii, s);
                backtrack(s, i+1, j, res);
                s=swap(i, ii, s);
            }
        }


    }


    private String swap(int i, int j, String s){
        char[] chars = s.toCharArray();
        char buf = chars[i];
        chars[i] = chars[j];
        chars[j] = buf;
        return String.valueOf(chars);
    }


    public static void main(String[] args){
        PermuteString ps = new PermuteString();
        ps.permute("abc");
    }
}
