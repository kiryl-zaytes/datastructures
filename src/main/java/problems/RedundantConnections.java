package problems;

/**
 * Created by kiryl_zayets on 2/27/19.
 */
public class RedundantConnections {

    int[] ds;

    public int[] findRedundantConnection(int[][] edges) {
        int[] res = new int[2];
        ds = new int[edges.length+1];
        for(int i=0; i<ds.length; i++) ds[i] = i;

        for(int i=0; i<edges.length; i++){
            int p =edges[i][0];
            int q =edges[i][1];

            if (connected(p, q)) {
                res[0] = p;
                res[1] = q;
            }
            else union(p, q);
        }

        return res;
    }


    private void union(int p, int q){
        while (p != ds[p]) p = ds[p];
        while (q != ds[q]) q = ds[q];
        ds[q] = p;
    }

    private boolean connected(int p, int q){
        while (p != ds[p]) p = ds[p];
        while (q != ds[q]) q = ds[q];
        return ds[p] == ds[q];
    }


}
