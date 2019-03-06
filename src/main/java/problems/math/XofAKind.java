package problems.math;

import java.util.HashMap;

/**
 * Created by kiryl_zayets on 3/6/19.
 */
public class XofAKind {


    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer, Integer> storage = new HashMap<>();
        for(int i=0; i< deck.length; i++){
            storage.put(deck[i], storage.getOrDefault(deck[i], 0)+1);
        }

        int res = 0;

        for(int k : storage.keySet()){
            int v = storage.get(k);
            res = gcd(v, 0);
        }

        return res > 1;
    }


    private int gcd(int n, int d){
        if (n==0) return d;
        return gcd(d, n%d);
    }

}
