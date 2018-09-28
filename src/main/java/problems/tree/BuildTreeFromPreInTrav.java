package problems.tree;

/**
 * preorder array keeps tree parent nodes and childs follow immediately if they exist.
 * To get an idea how many childs and what they are we need inorder array.
 * 1. First element of preorder array is root of tree. Get it and search its position in
 * inorder array. All to the left of its position are left nodes, to the right - right nodes.
 * 2. Calculate indices : left tree length(up to that root node) and right tree (beyond that root node) length.
 * 3. Change low and high positions of both array to use recursion. Move left side until null than move right to build each node from bottom
 * to up.
 * 4. Algorithm could be improved by using hash map instead of sequential search.
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
