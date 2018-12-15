package problems.string;

import java.util.LinkedList;

/**
 * Created by kiryl_zayets on 12/14/18.
 */
public class NumberOfMatchingSubsequence {

    public int numMatchingSubseq(String S, String[] words) {

        LinkedList<String>[] storage = (LinkedList<String>[]) new
                LinkedList[256];

        for (int i = 0; i < storage.length; i++) storage[i] = new LinkedList<>();
        for (String w : words) storage[w.charAt(0)].add(w);

        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            LinkedList<String> tmp = storage[S.charAt(i)];
            int size = tmp.size();
            for (int j = 0; j < size; j++) {
                String t = tmp.removeFirst();
                if (t.length() == 1) count++;
                else storage[t.charAt(1)].addLast(t.substring(1));
            }
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOfMatchingSubsequence nms = new NumberOfMatchingSubsequence();
        System.out.print(nms.numMatchingSubseq("abcde", new String[]{"a",
                "bb", "acd", "ace"}));
    }

}
