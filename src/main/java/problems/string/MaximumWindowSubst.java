package problems.string;

/**
 * 1. arrange array of integers to keep count and values as index of each character in window string.
 * 2. scan through character and increase corresponding indexes.
 * 3. Iterate over first string to find first window : create two pointers (start and end),
 * first end goes to reach right border of window. Border is when all characters from map met (decrease value if char index each time we find it).
 * Then when number of met characters == to window length we should start moving "start" pointer to find shorter window: literally to cut all the values from the
 * left which are not in prefix we are are looking for. As we find first that char we should increment prefix length to let first cycle work again and move end
 * pointer forward.
 * Each time when we find window we need to store its size if it less than previous nad its starting index.
 */
public class MaximumWindowSubst {

    public String minWindow1(String s, String t) {

        int[] map = new int[128];
        for (char c : t.toCharArray()) map[c]++;

        int start = 0;
        int end = 0;
        int minLength = Integer.MAX_VALUE;
        int seq = t.length();
        int startFrom = 0;


        while (end < s.length()) {

            if (map[s.charAt(end)] > 0) seq--;
            map[s.charAt(end)]--;
            end++;

            while (seq == 0) {

                if (end - start < minLength) {
                    startFrom = start;
                    minLength = end - start;
                }

                map[s.charAt(start)]++;
                if (map[s.charAt(start)] > 0) seq++;
                start++;
            }

        }

        if (minLength != Integer.MAX_VALUE)
            return s.substring(startFrom, startFrom+minLength);
        return "";

    }

    public String minWindow(String s, String t) {

        int[] storage = new int[256];
        int l = t.length();
        int slow = 0;
        int fast = 0;
        int maxLength = Integer.MAX_VALUE;
        String res = "";


        for(int i=0; i < t.length(); i++) storage[t.charAt(i)]++;

        while(fast < s.length()){

            if(storage[s.charAt(fast)] > 0) l--;
            storage[s.charAt(fast)]--;
            fast++;

            while(l==0){

                if (fast - slow < maxLength){
                    maxLength = fast - slow;
                    res = s.substring(slow, fast);
                }

                storage[s.charAt(slow)]++;
                if(storage[s.charAt(slow)] > 0) l++;
                slow++;

            }

        }

        return res;

    }


    public static void main(String[] args) {
        MaximumWindowSubst mws = new MaximumWindowSubst();
        System.out.print(mws.minWindow("ADOBECODEBANC", "ABC"));
    }

}
