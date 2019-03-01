package problems.trie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by kiryl_zayets on 2/20/19.
 */
public class AutocompleteSystem {


    class Node{
        String val;
        int times;
    }

    class Trie {
        Trie[] nodes = new Trie[256];
        int times = 0;
        String value;
    }

    Trie root;
    StringBuilder sb = new StringBuilder();

    public AutocompleteSystem(String[] sentences, int[] times) {
        int i=0;
        for(String s : sentences) insert(s, times[i++]);
    }

    public List<String> input(char c) {
        if (c == '#') {
            insert(sb.toString(), 1);
            sb.setLength(0);
            return new ArrayList<>();
        }

        else {

            sb.append(c);
            List<Node> res = getByPrefix(sb.toString());
            Collections.sort(res, new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    if (o1.times == o2.times) return o1.val.compareTo(o2.val);
                    return o2.times - o1.times;
                }
            });

            ArrayList<String> result = new ArrayList<>();

            int i = (res.size() < 4)? res.size() : 3;
            for(int j=0; j < i; j++){
                result.add(res.get(j).val);
            }
            return result;
        }
    }


    public List<Node> getByPrefix(String prefix){
        Trie node = get(root, prefix, 0);
        ArrayList<Node> res = new ArrayList<>();
        collect(node, prefix, res);
        return res;
    }


    private Trie get(Trie root, String prefix, int ch){
        if (root == null) return null;
        if (prefix.length() == ch) return root;
        char c = prefix.charAt(ch);
        return get(root.nodes[c], prefix, ch+1);
    }


    private void collect(Trie root, String prefix, List<Node> res){
        if (root == null) return;
        if (root.value != null) {
            Node n = new Node();
            n.times = root.times;
            n.val  = root.value;
            res.add(n);
        }
        for (int i=0; i<256; i++) collect(root.nodes[i], prefix+i, res);
    }



    public void insert(String s, int time){
        root = insert(root, s, 0, time);
    }

    private Trie insert(Trie root, String s, int ch, int time){

        if (root == null) root = new Trie();
        if (ch == s.length()) {
            root.times += time;
            root.value = s;
            return root;
        }
        char c = s.charAt(ch);
        root.nodes[c] = insert(root.nodes[c], s, ch+1, time);
        return root;
    }


    public static void main(String[] args){
        AutocompleteSystem ac = new AutocompleteSystem(new String[]{"i love you","island","iroman","i love leetcode"}, new int[]{5,3,2,2});
        ac.input('i');
        ac.input(' ');
        ac.input('a');
        ac.input('#');
    }

}
