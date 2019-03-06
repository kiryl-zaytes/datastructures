package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kiryl_zayets on 3/5/19.
 */
public class MyCalendar {

    List<Interval> calendar;

    class Interval{

        int s;
        int e;

        public Interval(int s, int e){
            this.s = s;
            this.e = e;
        }
    }


    public MyCalendar() {
        calendar = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for (Interval i : calendar){
            if (end > i.s && start < i.e) return false;
        }
        calendar.add(new Interval(start, end));
        return true;

    }


    public static void main(String[] args){

        MyCalendar mc = new MyCalendar();
        System.out.print(mc.book(10, 20));
        System.out.print(mc.book(15, 25));
        System.out.print(mc.book(20, 30));
    }


}
