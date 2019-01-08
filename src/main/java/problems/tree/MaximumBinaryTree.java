package problems.tree;

/**
 * Created by kiryl_zayets on 12/27/18.
 */
public class MaximumBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }


    private TreeNode helper(int[] nums, int l, int r){
        if (l > r) return null;
        int max = Integer.MIN_VALUE;
        int pos = 0;
        for (int i=l; i <= r; i++) if (nums[i] > max) {
            max = nums[i];
            pos = i;
        }
        TreeNode root = new TreeNode(nums[pos]);
        root.left = helper(nums, l, pos-1);
        root.right = helper(nums, pos+1, r);
        return root;
    }


    public static void main(String[] args){
        MaximumBinaryTree mbt = new MaximumBinaryTree();
        TreeNode tr = mbt.constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5});
        System.out.print(tr.left);
    }


}
