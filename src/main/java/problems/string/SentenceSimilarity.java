package problems.string;

import java.util.HashSet;

/**
 * Created by kiryl_zayets on 2/26/19.
 */
public class SentenceSimilarity {

    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {

        if (words1.length != words2.length) return false;

        HashSet<String> storage = new HashSet<>();

        for (int i=0; i < pairs.length; i++){
            String[] inner = pairs[i];
            storage.add(inner[0] + '#' + inner[1]);
            storage.add(inner[1] + '#' + inner[0]);
        }

        for (int i = 0; i < words1.length; i++){
            if (!words1[i].equals(words2[i])){
                String s1 = words1[i] + '#' + words2[i];
                String s2 = words2[i] + '#' + words1[i];

                if (!storage.contains(s1) &&
                        !storage.contains(s2)) return false;
            }
        }

        return true;
    }

}
