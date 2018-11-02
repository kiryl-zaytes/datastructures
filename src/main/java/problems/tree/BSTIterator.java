package problems.tree;

import java.util.Stack;

/**
 * Created by kiryl_zayets on 11/2/18.
 */
public class BSTIterator {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    TreeNode head;

    Stack<TreeNode> storage;

    public BSTIterator(TreeNode root) {
        head = root;
        storage = new Stack<>();
        add(root);
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        if (storage.empty()) return false;
        return true;
    }

    public void add(TreeNode tr) {
        while (tr != null) {
            storage.push(tr);
            tr = tr.left;
        }
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode tr = storage.pop();
        add(tr.right);
        return tr.val;
    }


    public static void main(String[] args) {
        TreeNode r = new TreeNode(5);
        TreeNode g1 = new TreeNode(3);
        TreeNode g2 = new TreeNode(6);


        TreeNode g3 = new TreeNode(7);
//        TreeLinkNode g4 = new TreeLinkNode(7);
        r.left = g1;
        r.right = g2;
        g2.right = g3;
//        g2.right = g4;

        g1.left = new TreeNode(2);
        g1.right = new TreeNode(4);
        //g3.right = new TreeLinkNode(16);
        BSTIterator bst = new BSTIterator(r);
        System.out.println(bst.next());
        System.out.println(bst.next());
        System.out.println(bst.next());
        System.out.println(bst.next());
    }


}
