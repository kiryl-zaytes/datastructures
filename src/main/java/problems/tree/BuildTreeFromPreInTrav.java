package problems.tree;

/**
 * Created by kiryl_zayets on 9/27/18.
 */
public class BuildTreeFromPreInTrav {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length != inorder.length) return null;
        return helper(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);

    }

    public static TreeNode helper(int[] preorder,
            int pLow,
            int pHigh,
            int[] inorder,
            int iLow,
            int iHigh) {
        if (pLow > pHigh || iLow > iHigh) return null;


        TreeNode root = new TreeNode(preorder[pLow]);
        int inRoot = 0;

        for (int i = iLow; i <= iHigh; i++) {
            if (preorder[pLow] == inorder[i]) {
                inRoot = i;
                break;
            }
        }

        int leftTreeLength = inRoot - iLow;

        root.left = helper(preorder,
                pLow + 1, pLow + leftTreeLength, inorder, iLow, inRoot - 1);

        root.right = helper(preorder,
                pLow + leftTreeLength + 1, pHigh, inorder, inRoot + 1, iHigh);

        return root;
    }


    public static void main(String[] args){
        BuildTreeFromPreInTrav.buildTree(new int[]{3,9,20,15,7}, new int[] {9,3,15,20,7});

    }


}
