package problems.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by kiryl_zayets on 4/11/19.
 */
public class FilmClipping {


    class Interval {
        int start;
        int end;

        public Interval(int s, int e) {
            this.start = s;
            this.end = e;
        }
    }


    public int videoStitching(int[][] clips, int T) {

        Arrays.sort(clips, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        int curEnd = 0;
        int count = 0;
        int maxEnd = 0;

        for(int i=0; i < clips.length;){

            if(curEnd < clips[i][0]) return -1;

            while (i < clips.length && clips[i][0] <= curEnd){
                maxEnd = Math.max(clips[i][1], maxEnd);
                i++;
            }
            count++;
            curEnd = maxEnd;
            if (curEnd >= T) return count;
        }

        return -1;
    }

    public static void main(String[] args){
        FilmClipping fc = new FilmClipping();
      //  fc.videoStitching(new int[][]{{5,2}, {10,6}, {100,10}, {0,9}, {1,5}, {5,9} }, 10);


        System.out.print(fc.videoStitching(new int[][]{{0, 2}, {4, 6}, {8,
                10}, {1, 9},
                {1, 5}, {5, 9}}, 10));
//        System.out.print(fc.videoStitching(new int[][]{{0, 1}, {6, 8}, {0,
//                2}, {5, 6},
//                {0, 4}, {0, 3}, {6,7}, {1,3}, {4,7}, {1,4}, {2,5}, {2,6}, {3,4}, {4,5}, {5,7}, {6,9}}, 9));
    }
}
