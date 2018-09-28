package problems.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by kiryl_zayets on 9/27/18.
 */
public class NextRightPointer {

    public static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) { val = x; }
    }


    public static void connect(TreeLinkNode root) {
        if (root == null) return;
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.add(root);
        root.next=null;
        while (!queue.isEmpty()) {
            int l = queue.size();
            LinkedList<TreeLinkNode> intr = new LinkedList();
            for (int i = 0; i < l; i++) {
                TreeLinkNode n = queue.poll();
                if (intr.size() != 0) intr.getLast().next = n;
                if (i==l-1) n.next = null;
                intr.addLast(n);
                if (n.left != null) queue.add(n.left);
                if (n.right != null) queue.add(n.right);
            }
        }
    }

    public static void main(String[] args){
        TreeLinkNode r = new TreeLinkNode(1);
        TreeLinkNode g1 = new TreeLinkNode(2);
        TreeLinkNode g2 = new TreeLinkNode(3);
        TreeLinkNode g3 = new TreeLinkNode(6);
        TreeLinkNode g4 = new TreeLinkNode(7);
        r.left = g1;
        r.right = g2;
        g2.left = g3;
        g2.right = g4;

        g1.left = new TreeLinkNode(4);
        g1.right = new TreeLinkNode(5);
        //g3.right = new TreeLinkNode(16);


        NextRightPointer.connect(r);
    }

}
