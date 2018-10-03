package problems.array;

/**
 * Created by kiryl_zayets on 10/1/18.
 */
public class KthLargestInArray {


    class MaxQueue {

        int[] nums;
        int N = 0;

        public MaxQueue(int[] nums) {
            this.nums = nums;
            this.N = nums.length;
        }


        public int getMax() {
            if (N == 0) return 0;
            int max = nums[1];
            swap(N--, 1);
            sink(1);
            return max;
        }

        public void sink(int k) {

            while (k * 2 <= N) {
                int j = k * 2;
                if (j < N && less(j, j + 1)) j++;
                if (!less(k, j)) break;
                swap(k, j);
                k = j;
            }
        }

        public void toBinaryHeap() {

            int[] in = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                in[i + 1] = nums[i];
            }
            this.nums = in;
            for (int k = N / 2; k >= 1; k--) sink(k);
        }

        private boolean less(int i, int j) {
            return (nums[i] < nums[j]);
        }

        private void swap(int i, int j) {
            int b = nums[i];
            nums[i] = nums[j];
            nums[j] = b;
        }


    }


    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 1) return nums[0];
        MaxQueue maxQueue = new MaxQueue(nums);
        maxQueue.toBinaryHeap();
        int m = 0;
        while (k != 0) {
            m = maxQueue.getMax();
            k--;
        }
        return m;
    }


    public static void main(String[] args) {
        KthLargestInArray kth = new KthLargestInArray();
        kth.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4);
    }

}
