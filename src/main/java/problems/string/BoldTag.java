package problems.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * Created by kiryl_zayets on 2/25/19.
 */
public class BoldTag {

    class Interval{
        int start;
        int end;

        public Interval(int s, int e){
            start = s;
            end = e;
        }
    }

    public String addBoldTag(String s, String[] dict) {

        ArrayList<Interval> intervals = new ArrayList<>();
        for(int i=0; i < s.length(); i++){
            for (int j=0; j < dict.length; j++){
                if (s.startsWith(dict[j], i)) intervals.add(new Interval(i, i+dict[j].length()));
            }
        }

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });


        LinkedList<Interval> temp = new LinkedList<>();
        for (Interval i: intervals){
            if (temp.size() == 0) temp.add(new Interval(i.start, i.end));

            Interval l = temp.getLast();
            if (i.start <= l.end){
                temp.removeLast();
                temp.add(new Interval(l.start, Math.max(i.end, l.end)));
            }
            else if (i.start > l.end) temp.offer(new Interval(i.start, i.end));

        }
        StringBuilder sb = new StringBuilder();

        int prev = 0;
        for (Interval i : temp){
            sb.append(s.substring(prev, i.start));
            sb.append("<b>");
            sb.append(s.substring(i.start, i.end));
            sb.append("</b>");
            prev = i.end;
        }

        if (prev < s.length()) sb.append(s.substring(prev, s.length()));
        return sb.toString();
    }

    public static void main(String[] args){
        BoldTag bt = new BoldTag();
        bt.addBoldTag("aaabbcc", new String[]{"a","c"});
    }

}
