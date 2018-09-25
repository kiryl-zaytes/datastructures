package problems.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by kiryl_zayets on 9/25/18.
 */
public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> store = new HashMap<>();

        if (strs == null || strs.length == 0)
            return new ArrayList<>(store.values());

        for (String s : strs) {
            char[] chrs = s.toCharArray();
            Arrays.sort(chrs);
            String key = new String(chrs);
            if (!store.containsKey(key)) {
                ArrayList<String> v = new ArrayList<>();
                v.add(s);
                store.put(key, v);
            } else {
                ArrayList<String> intr = (ArrayList<String>) store.get(key);
                intr.add(s);
                store.put(key, intr);
            }

        }

        return new ArrayList<>(store.values());

    }


    public static void main(String[] args) {
        GroupAnagrams.groupAnagrams(new String[]{"eat", "tea", "tan", "ate",
                "nat", "bat"});
    }

}
