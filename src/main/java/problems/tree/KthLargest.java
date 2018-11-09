package problems.tree;

/**
 * Created by kiryl_zayets on 11/8/18.
 */
public class KthLargest {

    public static class TreeNode {
        int val;
        int h;

        TreeNode left;
        TreeNode right;

        TreeNode(int x, int h) {
            val = x;
            this.h = h;
        }
    }

    int[] nums;
    TreeNode root;
    int max;
    int count;

    int v;

    private int size(TreeNode n) {
        if (n == null) return 0;

        return n.h;
    }

    public KthLargest(int k, int[] nums) {
        max = k;
        count = k;
        for (int i = 0; i < nums.length; i++) root = helper(root, nums[i], 1);
    }


    private int walk(TreeNode node, int k) {
        int right = 0;

        while (k > 0) {
            if (node == null) right = 0;
            else right = size(node.right) + 1;

            if (right == k) return node.val;
            else if (right > k) {
                node = node.right;
            } else if (right < k) {
                k = k - right;
                node = node.left;
            }
        }
        return node.val;
    }

    public int add(int val) {
        helper(root, val, 1);
        max = count;
        return walk(root, max);
    }

    private TreeNode helper(TreeNode node, int val, int r) {
        if (node == null) return new TreeNode(val, 1);
        if (val > node.val) node.right = helper(node.right, val, node.h);
        else if (val <= node.val) node.left = helper(node.left, val, node.h);
        node.h = size(node.left) + size(node.right) + 1;
        return node;
    }


    public static void main(String[] args) {
        KthLargest kth = new KthLargest(3, new int[]{4, 5, 8, 2});
        System.out.print(kth.add(3));
        System.out.print(kth.add(5));
        System.out.print(kth.add(10));
        System.out.print(kth.add(9));
        System.out.print(kth.add(4));
    }

}
