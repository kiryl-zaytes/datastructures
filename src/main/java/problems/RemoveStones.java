package problems;

/**
 * Created by kiryl_zayets on 7/2/19.
 */
public class RemoveStones {

    public int removeStones(int[][] stones) {

        int N = stones.length;
        int[] components = new int[N];
        for(int i=0; i < N; i++) components[i] = i;

        for(int i= 0; i < stones.length; i++){
            for(int j=i+1; j < stones.length; j++){
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) union(components, i, j);
            }
        }
        int res = 0;

        for(int i=0; i<components.length; i++) if (components[i] != i) res++;

        return N - res;


    }


    private void union(int[] components, int p, int q){
        int pp = find(components, p);
        int qq = find(components, q);
        if( pp != qq) components[pp] = qq;
    }

    private int find(int[] component, int p){
        while(p != component[p]) p = component[p];
        return p;
    }


    public static void main(String[] args){
        RemoveStones rs = new RemoveStones();
        rs.removeStones(new int[][]{{0,0}});
    }
}
