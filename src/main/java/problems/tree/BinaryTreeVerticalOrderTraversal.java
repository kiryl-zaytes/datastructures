package problems.tree;

import java.util.*;

/**
 * Created by kiryl_zayets on 12/27/18.
 */
public class BinaryTreeVerticalOrderTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> horizontalLevel = new LinkedList<>();
        Queue<Integer> verticalZone = new LinkedList<>();
        HashMap<Integer, List<Integer>> storage = new HashMap<>();

        horizontalLevel.add(root);
        verticalZone.add(0);

        int min = 0;
        int max = 0;

        while (!horizontalLevel.isEmpty()) {

            TreeNode node = horizontalLevel.poll();
            int col = verticalZone.poll();

            if (!storage.containsKey(col)) storage.put(col, new ArrayList<>());
            storage.get(col).add(node.val);

            if (node.left != null) {
                horizontalLevel.add(node.left);
                verticalZone.add(col - 1);
                min = Math.min(min, col - 1);
            }
            if (node.right != null) {
                horizontalLevel.add(node.right);
                verticalZone.add(col + 1);
                max = Math.max(max, col + 1);
            }

        }

        for (int i = min; i <= max; i++) {
            res.add(storage.get(i));
        }
        return res;
    }


}
