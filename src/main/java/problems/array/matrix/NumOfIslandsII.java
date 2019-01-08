package problems.array.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by kiryl_zayets on 1/3/19.
 */
public class NumOfIslandsII {

    int[][] movements = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public List<Integer> numIslands2(int m, int n, int[][] positions) {

        ArrayList<Integer> res = new ArrayList<>();
        int[] storage = new int[m * n];

        int count = 0;
        Arrays.fill(storage, -1);

        for (int i = 0; i < positions.length; i++) {
            int[] coord = positions[i];
            int id = n * coord[0] + coord[1];
            storage[id] = id;
            count++;
            for (int[] move : movements) {

                int x = coord[0] + move[0];
                int y = coord[1] + move[1];
                int newRoot = n * x + y;
                if (x >= m || x < 0 || y >= n || y < 0 ||
                        storage[newRoot] == -1) continue;

                while (storage[newRoot] != newRoot) newRoot = storage[newRoot];

                if (newRoot != id) {
                    count--;
                    storage[newRoot] = id;
                }
            }
            res.add(count);
        }
        return res;
    }


    private void union(int[] storage, int p, int q) {
        while (p != storage[p]) p = storage[p];
        while (q != storage[q]) q = storage[q];
        storage[p] = q;
    }

    private boolean connected(int[] storage, int p, int q) {
        return storage[p] == storage[q];
    }

}
