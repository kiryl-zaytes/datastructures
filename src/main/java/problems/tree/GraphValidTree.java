package problems.tree;

/**
 * Created by kiryl_zayets on 12/28/18.
 */
public class GraphValidTree {

    int[] connected;
    int[] size;

    public boolean validTree(int n, int[][] edges) {
        connected = new int[n];
        size = new int[n];

        for (int i = 0; i < connected.length; i++) {
            connected[i] = i;
            size[i] = 1;
        }

        for (int i = 0; i < edges.length; i++) {
            int p = edges[i][0];
            int q = edges[i][1];

            if (!isConnected(p, q)) union(p, q);
            else return false;
        }

        int max = 0;

        for (int i = 0; i < size.length; i++) {
            max = Math.max(max, size[i]);
        }
        if (max != connected.length) return false;
        return true;
    }

    private void union(int p, int q) {

        while (connected[p] != p) p = connected[p];
        while (connected[q] != q) q = connected[q];

        if (size[p] > size[q]) {
            connected[q] = p;
            size[p] += size[q];
        } else {
            connected[p] = q;
            size[q] += size[p];
        }
    }

    private boolean isConnected(int p, int q) {
        return connected[p] == connected[q];
    }


}
