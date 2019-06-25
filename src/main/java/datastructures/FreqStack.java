package datastructures;

/**
 * Created by kiryl_zayets on 5/3/19.
 */


import java.util.*;

class FreqStack {

    class Element implements Comparable<Element> {
        Integer num;
        Integer freq;
        Integer pos;

        public Element(Integer num, Integer freq, Integer pos) {
            this.num = num;
            this.freq = freq;
            this.pos = pos;
        }

        @Override
        public boolean equals(Object o) {
            Element o1 = (Element) o;
            if (this.num == o1.num) return true;
            return false;
        }

        @Override
        public int hashCode() {
            return 1356 * num + 767 * freq + 323 * pos;
        }

        @Override
        public int compareTo(Element o) {
            Element el2 = (Element)o;

            if (this.freq > el2.freq) return -1;
            else if (this.freq < el2.freq) return 1;
            else {
                if (this.pos > el2.pos) return -1;
                else if (this.pos < el2.pos) return 1;
                else return 0;
            }
        }
    }

    PriorityQueue<Element> pq;
    HashMap<Integer, Integer> storage;
    int pos = 1;

    public FreqStack() {
        pq = new PriorityQueue<Element>();
        storage = new HashMap<>();
    }

    public void push(int x) {
        if (!storage.containsKey(x)) {
            storage.put(x, 0);
        }
        storage.put(x, storage.get(x)+1);
        pq.offer(new Element(x, storage.get(x), pos++));
    }

    public int pop() {
        return pq.poll().num;
    }

    public static void main(String[] args){
        FreqStack fs = new FreqStack();
        fs.push(5);
        fs.push(7);
        fs.push(5);
        fs.push(7);
        fs.push(4);
        fs.push(5);
        System.out.println(fs.pop());
        System.out.println(fs.pop());
        System.out.println(fs.pop());
        System.out.println(fs.pop());
    }
}

