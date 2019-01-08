package problems.array;

/**
 * Created by kiryl_zayets on 12/18/18.
 */
public class TrappingRainWater {

    public int trap(int[] height) {

        int l = 0;
        int h = height.length - 1;
        int res = 0;

        int leftMax = 0;
        int rightMax = 0;

        while (l < h) {

            if (height[l] < height[h]) {
                if (height[l] > leftMax) leftMax = height[l];
                else res+=leftMax - height[l];
                l++;
            }

            else {
                if (height[h] > rightMax) rightMax = height[h];
                else res+=rightMax - height[h];
                h--;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        TrappingRainWater tr = new TrappingRainWater();
        System.out.print(tr.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2,
                1}));
    }


}
