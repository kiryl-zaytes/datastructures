package problems.tree;

/**
 * Created by kiryl_zayets on 11/1/18.
 */
public class BuildTreeFormPrePost {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if (pre.length != post.length) return null;
        return helper(pre, post, 0, pre.length - 1, 0, post.length - 1);
    }


    private TreeNode helper(int[] pre,
            int[] post,
            int leftPre,
            int rigthPre,
            int leftPost,
            int rightPost) {

        if (leftPost > rightPost || leftPre > rigthPre) return null;

        TreeNode root = new TreeNode(post[rightPost--]);
        leftPre++;

        if (leftPost == rightPost+1 || leftPre-1 ==rigthPre) return root;


        int nextLeft = pre[leftPre];
        int split = 0;

        for (int i = leftPost; i <= rightPost; i++) {
            if (post[i] == nextLeft) {
                split = i;
                break;
            }
        }

        int leftTreeLength = split - leftPost;

        root.left = helper(pre, post, leftPre,
                leftPre + leftTreeLength, leftPost, split);

        root.right = helper(pre, post,
                leftPre + leftTreeLength+1, rigthPre, split+1, rightPost);

        return root;
    }


    public static void main(String[] args){
        BuildTreeFormPrePost bdp = new BuildTreeFormPrePost();
        TreeNode tr = bdp.constructFromPrePost(new int[]{1, 2, 4, 5, 3, 6, 7}, new
                int[]{4, 5, 2, 6, 7, 3, 1});
        System.out.print("");
    }
}
