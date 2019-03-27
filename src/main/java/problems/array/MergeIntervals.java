package problems.array;

import java.util.*;

/**
 * Created by kiryl_zayets on 10/4/18.
 */
public class MergeIntervals {

    public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }

//        @Override
//        public int compareTo(Object o) {
//            Interval g = (Interval)o;
//            if (this.start < g.start) return -1;
//            else if (this.start > g.start) return 1;
//            return 0;
//        }
    }


    private class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval a, Interval b) {
            return a.start < b.start ? -1 : a.start == b.start ? 0 : 1;
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null) return null;
        Collections.sort(intervals, new IntervalComparator());

        ArrayList<Interval> res = new ArrayList<>();


        for (Interval i : intervals){

            if (res.isEmpty() || res.get(res.size()-1).end < i.start) res.add(i);
            else {
                Interval tmp = res.get(res.size() - 1);
                tmp.end = Math.max(tmp.end, i.end);
            }
        }
        return res;
    }





    public List<Interval> merge1(List<Interval> intervals) {


        ArrayList<Interval> res = new ArrayList<>();
        if(intervals.size() == 0) return res;

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });


        for(Interval interval : intervals){
            if (res.size() == 0 || res.get(res.size()-1).end < interval.start ){
                res.add(interval);
                continue;
            }
            Interval tmp = res.get(res.size() - 1);
            tmp.end =  Math.max(tmp.end, interval.end);
        }
        return res;
    }


    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();
        ArrayList inter = new ArrayList<Interval>();
        inter.add(new Interval(1, 4));
        inter.add(new Interval(4, 5));
//        inter.add(new Interval(8, 10));
//        inter.add(new Interval(15, 18));

        mergeIntervals.merge1(inter);

    }

}
