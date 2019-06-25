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

    public int[][] merge3(int[][] intervals) {

        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return a[1] - b[1];
            }
        });

        ArrayList<Integer[]> res = new ArrayList<>();
        Integer[] lastAdded = null;



        for(int i = intervals.length-1; i >=0; i--){
            int[] tmp = intervals[i];
            if(res.size() != 0) lastAdded = res.get(res.size()-1);
            if(res.size() == 0 || lastAdded[0] > tmp[1]) res.add(new Integer[]{tmp[0], tmp[1]});
            else{
                lastAdded[0] = Math.min(lastAdded[0], tmp[0]);
                lastAdded[1] =  Math.max(lastAdded[1], tmp[1]);
            }
        }


        int[][] result = new int[res.size()][2];
        int i=0;
        for(Integer[] tmp: res){
            result[i][0] = tmp[0];
            result[i][1] = tmp[1];
            i++;
        }

        return result;
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
      //  inter.add(new Interval(1, 4));
        //inter.add(new Interval(4, 5));
//        inter.add(new Interval(8, 10));
//        inter.add(new Interval(15, 18));

     //   mergeIntervals.merge1(inter);
        mergeIntervals.merge3(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});

    }

}
