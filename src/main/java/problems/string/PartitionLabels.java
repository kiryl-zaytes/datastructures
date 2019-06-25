package problems.string;

import java.util.*;

/**
 * Created by kiryl_zayets on 6/23/19.
 */
public class PartitionLabels {

    public List<Integer> partitionLabels(String S) {
        ArrayList<Integer> res = new ArrayList<>();
        if(S.length() == 0) return res;
        int[] storage = new int[256];

        for(int i=0; i < S.length(); i++){
            storage[S.charAt(i)]++;
        }

        Queue<Character> q  = new LinkedList<>();
        HashSet<Character> seen = new HashSet<>();
        q.offer(S.charAt(0));
        seen.add(S.charAt(0));
        int l = 0;

        while(!q.isEmpty()){

            while(storage[q.peek()] > 0) {
                storage[S.charAt(l)]--;
                if(!seen.contains(S.charAt(l))) {
                    q.offer(S.charAt(l));
                    seen.add(S.charAt(l));
                }
                l++;
            }
            q.poll();

            if(q.isEmpty()){
                res.add(l);
                S = S.substring(l);
                l = 0;
                if (S.length() > 0) q.offer(S.charAt(0));
            }

        }
        return res;
    }

    public static void main(String[] args){
        PartitionLabels pl = new PartitionLabels();
        pl.partitionLabels("ababcbacadefegdehijhklij");
    }


}
