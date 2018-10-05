package problems.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by kiryl_zayets on 10/4/18.
 */
public class SerializeDeserializeBT {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }


    public String serialize(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuffer ser = new StringBuffer();
        queue.add(root);
        ser.append(String.valueOf(root.val));
       // ser.append(',');
        while (!queue.isEmpty()) {
            int layers = queue.size();

            for (int i = 0; i < layers; i++) {
                TreeNode node = queue.poll();
                if (node == null) continue;
                queue.add(node.left);
                queue.add(node.right);
                String l = (node.left ==
                        null) ? "|" : String.valueOf(node.left.val);
                String r = (node.right ==
                        null) ? "|" : String.valueOf(node.right.val);
                ser.append(',');
                ser.append(l);
                ser.append(',');
                ser.append(r);

            }
        }
        return ser.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data==null || data.length() == 0 || data=="") return null;
        int l = 1;
        int r = 2;
        String[] d = data.split(",");
        TreeNode head = new TreeNode(Integer.valueOf(d[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);

        for (int i = 0; i < d.length; i++) {

            if (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (!d[l].equals("|")) {
                    node.left = new TreeNode(Integer.valueOf(d[l]));
                    queue.add(node.left);
                    l += 2;
                } else {
                    i++;
                    l += 2;
                }

                if (!d[r].equals("|")) {
                    node.right = new TreeNode(Integer.valueOf(d[r]));
                    queue.add(node.right);
                    r += 2;
                } else {
                    i++;
                    r += 2;
                }
            }
        }
        return head;
    }


    public static void main(String[] args) {
        ArrayList a = new ArrayList();

        a.add(10, 10);
        a.add(0, 5);



        TreeNode r = new TreeNode(0);
        TreeNode g1 = new TreeNode(-1);
        TreeNode g2 = new TreeNode(1);
        r.left = g1;
        r.right = g2;

//        g2.left = new TreeNode(4);
//        g2.right = new TreeNode(5);
//        g1.left = new TreeNode(6);
//        g1.right = new TreeNode(7);

        SerializeDeserializeBT serializeDeserializeBT = new
                SerializeDeserializeBT();
        String s = serializeDeserializeBT.serialize(r);
        TreeNode root = serializeDeserializeBT.deserialize(s);

    }

}
