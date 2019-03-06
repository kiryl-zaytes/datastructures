import java.util.ArrayList;
import java.util.List;

/**
 * Created by kiryl_zayets on 3/5/19.
 */
public class MyCalendarTwo {


    List<Interval> singleBooked;
    List<Interval> doubleBooked;


    class Interval{

        int s;
        int e;

        public Interval(int s, int e){
            this.s = s;
            this.e = e;
        }

    }


    public MyCalendarTwo() {
        singleBooked = new ArrayList<>();
        doubleBooked = new ArrayList<>();
    }

    public boolean book(int start, int end) {

        for(Interval i : doubleBooked){
            if (end > i.s && start < i.e) return false;
        }

        for(Interval i : singleBooked){
            if(end > i.s && start < i.e) doubleBooked.add(new Interval(Math.max(start, i.s), Math.min(end, i.e)));
        }
        singleBooked.add(new Interval(start, end));
        return true;
    }

}
