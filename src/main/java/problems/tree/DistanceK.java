package problems.tree;


import java.util.*;


public class DistanceK {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    HashMap<TreeNode, TreeNode> parents;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {

        Queue<TreeNode> q = new LinkedList<>();
        HashSet<TreeNode> seen = new HashSet<>();
        parents = new HashMap<>();
        dfs(parents, root, null);

        q.add(null);
        q.add(target);
        seen.add(target);
        seen.add(null);
        return kdistance(q, seen, K);
    }

    private List<Integer> kdistance(Queue<TreeNode> q, HashSet<TreeNode> seen, int K ){

        int distance = 0;

        while (!q.isEmpty()){
            TreeNode node = q.poll();

            if (node == null){

                if (distance == K){
                    List<Integer> tmp = new ArrayList<>();
                    while (!q.isEmpty()) tmp.add(q.poll().val);
                    return tmp;
                }

                q.offer(null);
                distance++;
            }

            else {
                if (node.left != null) {
                    q.add(node.left);
                    seen.add(node.left);
                }
                if (node.right != null){
                    q.add(node.right);
                    seen.add(node.right);
                }
                TreeNode p = parents.get(node);
                if (p != null) {
                    q.add(p);
                    seen.add(p);
                }
            }
        }

        return new ArrayList<Integer>();
    }


    private void dfs(HashMap<TreeNode, TreeNode> parents, TreeNode root, TreeNode parent){
        if (root == null) return;
        parents.put(root, parent);
        dfs(parents, root.left, root);
        dfs(parents, root.right, root);
    }


    public static void main(String[] args){
        DistanceK dk = new DistanceK();

        TreeNode r = new TreeNode(3);
        TreeNode g1 = new TreeNode(5);
        TreeNode g2 = new TreeNode(1);
        r.left = g1;
        r.right = g2;
        g2.left = new TreeNode(0);
        g2.right = new TreeNode(8);

        g1.left = new TreeNode(6);
        g1.right = new TreeNode(2);

        g1.right.left = new TreeNode(7);
        g1.right.right = new TreeNode(4);
        dk.distanceK(r, g1, 2);
    }
}
