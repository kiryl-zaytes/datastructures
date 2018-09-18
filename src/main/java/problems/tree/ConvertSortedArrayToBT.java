package problems.tree;

/**
 * Created by kiryl_zayets on 9/17/18.
 */
public class ConvertSortedArrayToBT {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        return toBST(nums, 0, nums.length - 1);
    }

    public static TreeNode toBST(int[] nums, int l, int h) {
        if (l > h) return null;
        else System.out.println(l + "" + h);

        int m = l + (h - l) / 2;

        TreeNode lr = toBST(nums, l, m - 1);
        TreeNode rr = toBST(nums, m + 1, h);

        TreeNode n = new TreeNode(nums[m]);
        System.out.println(m);
        n.left = lr;
        n.right = rr;
//        System.out.println(n.val+""+lr+""+rr);
        return n;

    }


    public static void main(String[] args) {
        TreeNode head = ConvertSortedArrayToBT.sortedArrayToBST(new
                int[]{-10, -3, -2, 0, 5, 9, 10});
        System.out.print(head.left);
    }
}
