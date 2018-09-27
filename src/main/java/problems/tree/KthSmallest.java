package problems.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by kiryl_zayets on 9/27/18.
 */
public class KthSmallest {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    public static int kthSmallest2(TreeNode root, int k) {
        List<TreeNode> store = new LinkedList<>();
        helper(store, root.left);

        if (store.size() < k) {
            if (store.size() == --k) return root.val;
            root = root.right;

            k = k - store.size() - 1;
            while (root != null && k != 0) {
                if (root.left != null) root = root.left;
                else if (root.right != null) root = root.right;
                k--;
            }
        } else if (store.size() > k) {
            return store.get(store.size() - k - 1).val;
        } else return store.get(store.size() - 1).val;

        return root.val;
    }


    public static void helper(List<TreeNode> storage, TreeNode root) {
        if (root == null) return;
        helper(storage, root.left);
        storage.add(root);
        helper(storage, root.right);
    }


    static int count;
    static int value;

    public static int kthSmallest(TreeNode root, int k) {
        count = k;
        helper2(root);
        return value;
    }


    public static void helper2(TreeNode root) {

        if (root == null) return;

        helper2(root.left);
        count--;

        if (count == 0) value = root.val;

        helper2(root.right);

    }


    public static void main(String[] args) {
        TreeNode r = new TreeNode(5);
        TreeNode g1 = new TreeNode(3);
        TreeNode g2 = new TreeNode(6);
        r.left = g1;
        r.right = g2;
//        g1.left = new TreeNode(2);
//        g1.right = new TreeNode(4);
        //g1.left.left = new TreeNode(1);
//        g2.left = new TreeNode(4);
//        g2.right = new TreeNode(7);

        System.out.print(KthSmallest.kthSmallest(r, 1));
    }


}
