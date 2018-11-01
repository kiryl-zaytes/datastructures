package problems.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by kiryl_zayets on 9/15/18.
 */
public class SymmertricTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }


    public static boolean isSumetric(TreeNode root) {
        return helper(root.left, root.right);
    }

    private static boolean helper(TreeNode l, TreeNode r) {
        if (l == null && r == null) return true;
        if (l == null || r == null) return false;
        return (l.val == r.val) && helper(l.left, r.right) &&
                helper(l.right, r.left);
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        Deque<TreeNode> deque = new LinkedList<TreeNode>();
        deque.add(root);
        LinkedList<TreeNode> subl = new LinkedList<TreeNode>();
        int levels = 1;
        while (!deque.isEmpty()) {
            levels = deque.size();
            for (int i = 0; i < levels; i++) {
                TreeNode n = deque.remove();
                if (n.left != null) deque.add(n.left);
                if (n.right != null) deque.add(n.right);
                subl.add(n.left);
                subl.add(n.right);
            }
            while (!subl.isEmpty()) {
                if (subl.getFirst() != null && subl.getLast() != null) {
                    if (subl.getFirst().val != subl.getLast().val) return false;
                } else if (subl.getFirst() == null && subl.getLast() != null)
                    return false;
                else if (subl.getFirst() != null && subl.getLast() == null)
                    return false;
                subl.removeFirst();
                subl.removeLast();
            }

        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode r = new TreeNode(1);
        TreeNode g1 = new TreeNode(2);
        TreeNode g2 = new TreeNode(2);
        r.left = g1;
        r.right = g2;
//           g1.left = new TreeNode(3);
        g1.right = new TreeNode(3);
//        g2.left = new TreeNode(4);
        g2.right = new TreeNode(3);

        System.out.print(SymmertricTree.isSumetric(r));
        System.out.print(SymmertricTree.isSymmetric(r));
    }

}
