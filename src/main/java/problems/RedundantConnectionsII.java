package problems;

import java.util.Arrays;

/**
 * Created by kiryl_zayets on 2/27/19.
 */
public class RedundantConnectionsII {


    int[] u;

    public int[] findRedundantDirectedConnection(int[][] edges) {

        int[] res = new int[2];

        u = new int[edges.length+1];
        for (int i=0; i< u.length; i++) u[i] = i;

        int[] parents = new int[edges.length+1];
        Arrays.fill(parents, -1);

        int first = -1, second = -1, last = -1;

        for (int i=0; i<edges.length; i++){

            int p = edges[i][0];
            int c = edges[i][1];

            if (parents[c] != -1){
                first = parents[c];
                second = i;
                continue;
            }

            parents[c] = i;

            if (connected(p, c)) last = i;
        }

        if (last == -1) return edges[second];
        if (second == -1) return edges[last];
        else return edges[first];
    }


    private void union(int p, int q){
        while (p != u[p])  p = u[p];
        while (q != u[q]) q = u[q];
        u[q] = p;
    }


    private boolean connected(int p, int q){
        return u[p] == u[q];
    }

}
