package problems.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by kiryl_zayets on 12/7/18.
 */
public class AverageOfLevels {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    public List<Double> averageOfLevels(TreeNode root) {
        ArrayList list = new ArrayList();
        helper(root, list);
        return list;

    }

    private void helper(TreeNode root, List<Double> res) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int l = queue.size();
            double levelRes = 0;
            for (int i = 0; i < l; i++) {
                TreeNode node = queue.poll();
                levelRes += node.val;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(levelRes / l);
        }
    }

}
