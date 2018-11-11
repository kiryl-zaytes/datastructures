package problems.tree;

import java.util.HashMap;

/**
 * Created by kiryl_zayets on 11/11/18.
 */
public class PathSumIII {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    public int pathSum(TreeNode root, int sum) {

        HashMap<Integer, Integer> s = new HashMap<>();
        s.put(0,1);
        return helper(root, sum, 0, s);
    }


    private int helper(TreeNode root,
            int sum,
            int intermSum,
            HashMap<Integer, Integer> storage) {

        if (root == null) return 0;

        intermSum += root.val;
        int res = storage.getOrDefault(intermSum - sum, 0);
        storage.put(intermSum, storage.getOrDefault(intermSum, 0) + 1);

        res += helper(root.left, sum, intermSum, storage);
        res += helper(root.right, sum, intermSum, storage);

        storage.put(intermSum, storage.get(intermSum) - 1);
        return res;

    }

    public static void main(String[] args) {
        PathSumIII p3 = new PathSumIII();

        TreeNode r = new TreeNode(10);
        TreeNode g1 = new TreeNode(5);
        TreeNode g2 = new TreeNode(-3);
        r.left = g1;
        r.right = g2;

        g1.left = new TreeNode(3);
        g1.right = new TreeNode(2);
        g1.right.right = new TreeNode(1);


        g1.left.left = new TreeNode(3);
        g1.left.right = new TreeNode(-2);

//        g2.left = new TreeNode(13);
        g2.right = new TreeNode(11);
//        g2.right.right = new TreeNode(1);
//        g2.right.left = new TreeNode(5);
        System.out.print(p3.pathSum(r, 8));

    }

}
