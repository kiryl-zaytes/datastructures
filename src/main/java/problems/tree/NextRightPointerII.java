package problems.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by kiryl_zayets on 10/29/18.
 */
public class NextRightPointerII {

    public static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) { val = x; }
    }

    public static void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> storage = new LinkedList<>();
        storage.add(root);
        while (!storage.isEmpty()) {
            int l = storage.size();
            for (int i = 0; i < l; i++) {
                TreeLinkNode node = storage.poll();
                if (i == l - 1) node.next = null;
                else node.next = storage.peek();
                if (node.left != null) storage.offer(node.left);
                if (node.right != null) storage.add(node.right);
            }
        }
    }


    public static void connectConstantSpace(TreeLinkNode root){
        TreeLinkNode node = root;
        TreeLinkNode headLevel = new TreeLinkNode(0);
        TreeLinkNode needle;

        while (node != null){
            needle = headLevel;

            while (node != null){

                if (node.left != null){
                    needle.next = node.left;
                    needle = needle.next;
                }

                if (node.right != null){
                    needle.next = node.right;
                    needle = needle.next;
                }

                node = node.next;
            }

            node = headLevel.next;
            headLevel.next = null;
        }

    }



    public static void main(String[] args) {
        TreeLinkNode r = new TreeLinkNode(1);
        TreeLinkNode g1 = new TreeLinkNode(2);
        TreeLinkNode g2 = new TreeLinkNode(3);


        TreeLinkNode g3 = new TreeLinkNode(7);
//        TreeLinkNode g4 = new TreeLinkNode(7);
        r.left = g1;
        r.right = g2;
        g2.right = g3;
//        g2.right = g4;

        g1.left = new TreeLinkNode(4);
        g1.right = new TreeLinkNode(5);
        //g3.right = new TreeLinkNode(16);


//        NextRightPointerII nextRightPointerII  = new NextRightPointerII();
        NextRightPointerII.connectConstantSpace(r);
        System.out.print("");
    }
}
