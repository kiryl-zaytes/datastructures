package problems.time;

import java.util.Arrays;

/**
 * Created by kiryl_zayets on 1/3/19.
 */
public class MeetingRoomII {

    public class Interval {
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
    }

    public int minMeetingRooms(Interval[] intervals) {

        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];

        for (int i = 0; i< intervals.length; i++){
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }
        Arrays.sort(start);
        Arrays.sort(end);

        int rooms = 0;
        int iter = 0;

        for (int i=0; i < start.length; i++){

            if (start[i] < end[i]) rooms++;
            else iter++;
        }

        return rooms;
    }

}
