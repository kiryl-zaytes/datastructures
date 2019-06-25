package problems.array;

/**
 * Created by kiryl_zayets on 5/14/19.
 */
public class FrogJump {

    public static boolean canCross(int[] stones) {

        int leap = 1;

        int current = stones[0];

        for(int i=1; i < stones.length; i++){
            if (i == stones.length-1) return true;
            if (current + leap >= stones[i]) continue;
            leap++;
            i--;
            current = stones[i];

        }

        return false;
    }

    public static void main(String[] args){

        FrogJump.canCross(new int[]{0,1,2,3,4,8,9,11});
    }


}
