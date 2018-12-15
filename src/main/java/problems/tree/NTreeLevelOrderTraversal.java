package problems.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by kiryl_zayets on 11/29/18.
 */
public class NTreeLevelOrderTraversal {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };


    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        helper(root, res);
        return res;
    }


    private void helper(Node root, List<List<Integer>> res){

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int levels = 0;
        while (!queue.isEmpty()){
            levels = queue.size();
            ArrayList tmp = new ArrayList();
            for(int i=0; i < levels; i++){
                Node t = queue.poll();
                int s = 0;
                while (s < t.children.size()) queue.add(t.children.get(s++));
                tmp.add(t.val);
            }
            res.add(tmp);
        }
    }


}
