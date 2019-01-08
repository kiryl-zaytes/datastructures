package problems.tree;

import java.util.HashSet;

/**
 * Created by kiryl_zayets on 12/6/18.
 */
public class SubtreeOfAnotherTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        HashSet<String> storage = new HashSet<>();
        HashSet<String> storage1 = new HashSet<>();
        helper(s, storage);
        helper(t, storage1);
        storage1.removeAll(storage);
        return storage1.isEmpty();
    }


    private String helper(TreeNode root, HashSet<String> storage) {
        if (root == null) return "";
        String l = helper(root.left, storage);
        String r = helper(root.right, storage);
        String res = l + "|" + r + root.val + "|";
        storage.add(res);
        return res;
    }


    public boolean isSubtree1(TreeNode s, TreeNode t) {
        if (s == null) return false;
        if (isSame(s, t)) return true;
        return isSubtree1(s.left, t) || isSubtree1(s.right, t);
    }


    private boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.val != t.val) return false;
        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }

    public static void main(String[] args) {
        TreeNode r = new TreeNode(3);
        TreeNode g1 = new TreeNode(4);
        TreeNode g2 = new TreeNode(5);
        r.left = g1;
        r.right = g2;

        g1.left = new TreeNode(1);
        g1.right = new TreeNode(2);

        TreeNode r1 = new TreeNode(4);
        r1.left = new TreeNode(1);
        r1.right = new TreeNode(2);

        SubtreeOfAnotherTree ft = new SubtreeOfAnotherTree();
        System.out.print(ft.isSubtree(r, r1));
    }

}
