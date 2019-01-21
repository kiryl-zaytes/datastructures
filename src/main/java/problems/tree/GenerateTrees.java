package problems.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kiryl_zayets on 1/21/19.
 */
public class GenerateTrees {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

   public List<TreeNode> generateTrees(int n){

       if (n==0) return new ArrayList<>();
       return generetaTree(1, n);

   }

    private List<TreeNode> generetaTree(int start, int end){
        ArrayList<TreeNode> temp = new ArrayList<>();
        if (start > end) temp.add(null);

        for (int i=start; i<=end; i++){

            List<TreeNode> l = generetaTree(start, i-1);
            List<TreeNode> r = generetaTree(i+1, end);

            for (TreeNode ln : l){
                for (TreeNode rn : r){
                    TreeNode root = new TreeNode(i);
                    root.left = ln;
                    root.right = rn;
                    temp.add(root);
                }
            }
        }
        return temp;
    }

    public static void main(String[] args){
        GenerateTrees gt = new GenerateTrees();
        gt.generateTrees(4);

    }

}
