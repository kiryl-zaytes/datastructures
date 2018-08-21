package datastructures.unionfind;

/**
 * Created by kiryl_zayets on 8/21/18.
 */
public class UF {
    private int[] connections;

    public UF(int n) {
        connections = new int[n];

        for (int i = 0; i < connections.length; i++) {
            connections[i] = i;
        }
    }

    public void union(int n, int m) {
        int p;
        int q;
        while (connections[m] != m) {
            m = connections[m];
        }
        p = m;
        while (connections[n] != n) {
            n = connections[n];
        }
        q = n;
        connections[n] = p;
    }

    public boolean connected(int p, int q) {
        return connections[p] == connections[q];
    }

    public static void main(String[] args) {
        UF uf = new UF(5);
        uf.union(2, 3);
        uf.union(4, 2);

        System.out.print(uf.connected(3, 4));

        uf.union(0, 4);
        System.out.print(uf.connected(0, 3));

        System.out.print(uf.connected(1, 4));
    }


}
