package problems.tree;

/**
 *  leftPost, leftPost + lengthOfLeftTree - 1 to cut left part of postorder array.
 *  leftPost+lengthOfLeftTree, rightPost - 1 - to cut right part of it.
 *  splitPos to control inorder array, in this array splitPosition is root, left
 *  tree is splitPos -1, and right splitPos+1;
 *
 */
public class BuildTreeFromInPost {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }


    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length != postorder.length) return null;
        return helper(inorder, postorder, 0,
                inorder.length - 1, 0, postorder.length - 1);
    }


    private TreeNode helper(int[] inorder,
            int[] postorder,
            int leftIn,
            int rightIn,
            int leftPost,
            int rightPost) {

        if (leftIn > rightIn || leftPost > rightPost) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[rightPost]);

        int splitPosition = 0;

        for (int i = 0; i <= rightIn; i++) {
            if (inorder[i] == postorder[rightPost]) {
                splitPosition = i;
                break;
            }
        }

        int lengthOfLeftTree = splitPosition - leftIn;

        root.left = helper(inorder, postorder, leftIn, splitPosition - 1,
                leftPost, leftPost + lengthOfLeftTree - 1);

        root.right = helper(inorder, postorder, splitPosition + 1, rightIn,
                leftPost+lengthOfLeftTree, rightPost - 1);

        return root;
    }


    public static void main(String[] args) {
        BuildTreeFromInPost buildTreeFromInPost = new BuildTreeFromInPost();
        TreeNode tr = buildTreeFromInPost.buildTree(new int[]{1,2,3,4,5}, new
                int[]{1,4,5,3,2});
        System.out.print(tr.left);

    }

}
