package problems.tree;


import java.util.*;

/**
 * Created by kiryl_zayets on 9/26/18.
 */
public class InorderTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root != null) helper(root, res);
        return res;
    }


    public static void helper(TreeNode root, List<Integer> l) {
        if (root == null) return;
        helper(root.left, l);
        System.out.println(root.val);
        l.add(root.val);
        helper(root.right, l);
    }

    public static void inorderIterative(TreeNode node) {
        if (node == null) return;
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode p = node;

        while (!deque.isEmpty() || p != null) {

            if (p != null) {
                deque.push(p);
                p = p.left;
            } else {
                TreeNode res = deque.pop();
                System.out.println(res.val);
                p = res.right;
            }
        }
    }


    public static void postOrder(TreeNode node) {
        if (node == null) return;

        LinkedList<TreeNode> res = new LinkedList<>();

        TreeNode p = node;

        Deque<TreeNode> stack = new ArrayDeque<>();

        while (!stack.isEmpty() || p != null) {

            if (p != null){
                res.addFirst(p);
                stack.push(p);
                p = p.right;
            }
            else {
                TreeNode tmp = stack.pop();
                p = tmp.left;
            }

        }
    }

    public static void preorderIterative(TreeNode node) {
        if (node == null) return;

        Deque<TreeNode> stack = new ArrayDeque<>();

        TreeNode p = node;

        while (!stack.isEmpty() || p != null) {

            if (p != null) {
                System.out.println(p.val);
                stack.push(p);
                p = p.left;
            } else {
                TreeNode tmp = stack.pop();
                p = tmp.right;
            }

        }
    }


    public static void main(String[] args) {
        TreeNode r = new TreeNode(1);
        TreeNode g1 = new TreeNode(2);
        TreeNode g2 = new TreeNode(3);
        r.right = g1;
//        r.right = g2;
//        g2.left = new TreeNode(15);
//        g2.right = new TreeNode(17);
        g1.left = g2;

        InorderTraversal.inorderTraversal(r);
        InorderTraversal.inorderIterative(r);
    }


}
