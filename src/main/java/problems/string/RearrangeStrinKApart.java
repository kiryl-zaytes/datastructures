package problems.string;


import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by kiryl_zayets on 2/15/19.
 */
public class RearrangeStrinKApart {

    public String rearrangeString(String s, int k) {
        if (s.length() == 0 || s.length() == 1 ) return s;
        if (k <=1) return s;

        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> entries = new HashMap<>();

        //int [] storage = new int[26];

        for (int i = 0; i < s.length(); i++)
            entries.put(s.charAt(i), entries.getOrDefault(s.charAt(i), 0) + 1);

        PriorityQueue<HashMap.Entry<Character, Integer>> pq = new
                PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {

                if (o1.getValue() == o2.getValue()) return o2.getKey() - o1.getKey();
                return o2.getValue() - o1.getValue();
            }
        });
        //(o1, o2) -> o2.getValue() - o1.getValue()
        pq.addAll(entries.entrySet());


        while (!pq.isEmpty()) {

            int interval = 0;
            HashMap<Character, Integer> temp = new HashMap<>();
            while (!pq.isEmpty() && interval < k) {

                if (!pq.isEmpty()) {
                    if (pq.peek().getValue() > 0) {
                        Character c = pq.peek().getKey();
                        sb.append(c);
                        temp.put(pq.peek().getKey(), pq.poll().getValue() - 1);
                        interval++;
                    } else pq.poll();

                }

            }
            if (sb.length() == s.length()) return sb.toString();
            if (interval < k) return "";
            pq.addAll(temp.entrySet());

        }

        return sb.toString();

    }

    public static void main(String[] args) {

        RearrangeStrinKApart rs = new RearrangeStrinKApart();
        System.out.print(rs.rearrangeString("abcdabcdabdeac", 4));
    }

}
