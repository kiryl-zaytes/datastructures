package problems.string;

import java.util.*;

/**
 * Created by kiryl_zayets on 7/2/19.
 */
public class RemoveInvalidParantheses {
    public List<String> removeInvalidParentheses(String s) {

        ArrayList<String> res = new ArrayList<>();
        if (s == null) return res;

        HashSet<String> cache = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(s);
        cache.add(s);
        boolean levelStop = false;
        while(!q.isEmpty()){
            String str = q.poll();

            if(isValid(str)){
                res.add(str);
                levelStop = true;
            }

            if (levelStop) continue;

            for(int i =0 ; i < str.length(); i++){
                if (str.charAt(i) != ')' && str.charAt(i) != '(') continue;
                String tmp = str.substring(0, i) + str.substring(i+1);

                if(!cache.contains(tmp)){
                    q.offer(tmp);
                    cache.add(tmp);
                }
            }


        }
        return res;
    }



    private boolean isValid(String s){
        int count = 0;

        for(int i=0; i < s.length(); i++){
            if(s.charAt(i) == '(') count++;
            if(s.charAt(i) == ')' && count-- == 0) return false;
        }

        return count == 0;
    }


    public static void main(String[] args){
        RemoveInvalidParantheses rip = new RemoveInvalidParantheses();
        rip.removeInvalidParentheses(")(");
    }
}
