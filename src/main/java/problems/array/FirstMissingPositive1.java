package problems.array;

import java.util.Arrays;

/**
 * Created by kiryl_zayets on 10/9/18.
 */
public class FirstMissingPositive1 {


    static class MinHeap {

        int[] heap;
        int N;

        public MinHeap(int[] arr) {
            this.heap = arr;
            this.N = heap.length - 1;
        }

        public boolean isEmpty() {
            return N == 0;
        }

        public void heapify() {
            for (int i = N / 2; i > 0; i--) {
                sink(i);
            }
        }


        public void swim(int k) {
            while (k / 2 > 1) {
                if (greater(k, k / 2)) swap(k, k / 2);
                k = k / 2;
            }
        }

        public void sink(int k) {
            while (k * 2 <= N) {
                int i = k * 2;
                if (i < N && greater(i, i + 1)) i = i + 1;
                if (greater(k, i)) swap(k, i);
                else break;
                k = i;
            }
        }


        public int getMin() {
            int min = Integer.MIN_VALUE;
            if (N > 0) {
                min = heap[1];
                heap[1] = heap[N--];
                sink(1);
            }
            return min;
        }

        private boolean greater(int n, int k) {
            return heap[n] > heap[k];
        }

        private void swap(int n, int k) {
            int b = heap[n];
            heap[n] = heap[k];
            heap[k] = b;
        }

    }


    public int getMissingPos(int[] test) {
        if (test.length == 0) return 1;
        test = Arrays.copyOf(test, test.length + 1);
        test[test.length - 1] = test[0];
        MinHeap minHeap = new MinHeap(test);
        minHeap.heapify();

        int firstPos = -1;

        while (!minHeap.isEmpty()) {
            int v = minHeap.getMin();
            if (v > 0) {
                firstPos = v;
                break;
            }
        }
        if (firstPos == -1 || firstPos > 1) return 1;

        int i = 1;
        int prev = 1;
        while (!minHeap.isEmpty()) {
            int v = minHeap.getMin();
            if (v != i) return i;
            else if (v == prev) prev = v;
            else {
                i++;
                prev = v;
            }
        }
        return i;
    }


    public static void main(String[] args) {
        FirstMissingPositive1 fmp = new FirstMissingPositive1();
        int[] test = new int[]{0,2,2,1,1};
        System.out.print(fmp.getMissingPos(test));

    }

}
