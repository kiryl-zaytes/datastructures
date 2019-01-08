package problems.tree;

import java.util.*;

/**
 * Created by kiryl_zayets on 12/19/18.
 */
public class RightSideBTView {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Queue<Integer> depth = new LinkedList<>();
        Queue<TreeNode> level = new LinkedList<>();
        HashMap<Integer, Integer> storage = new HashMap<>();
        depth.offer(0);
        level.offer(root);

        while (!level.isEmpty()) {

            int lvl = depth.poll();
            TreeNode node = level.poll();
            if (node.left != null) {
                level.offer(node.left);
                depth.offer(lvl + 1);
            }
            if (node.right != null) {
                level.offer(node.right);
                depth.offer(lvl + 1);
            }
            storage.put(lvl, node.val);
        }

        for(int k : storage.keySet()){
            res.add(storage.get(k));
        }

        return res;
    }


}
