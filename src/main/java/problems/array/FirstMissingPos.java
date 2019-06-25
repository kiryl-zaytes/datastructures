package problems.array;

/**
 * Created by kiryl_zayets on 10/10/18.
 */
public class FirstMissingPos {

    int[] test;

    public int getMissingPos1(int[] test) {
        if (test.length == 0 ) return 1;

        this.test = test;

        int border = organise();

        int res = border + 1;

        for (int i=0; i< border + 1; i++){
            int state = Math.abs(test[i]);
            if (state <= res) {
                test[state -1] = (test[state-1] > 0)? -test[state-1]: test[state-1];
            }
        }

        for(int i=0; i< res; i++){

            if (test[i] > 0) {
                res=i;
                break;
            }
        }

        return res+1;

    }


    private int organise() {
        int posBorder = 0;
        for (int i = 0; i < test.length; i++) {
            if (test[i] > 0) {
                swap(posBorder, i);
                posBorder++;
            }
        }
        return posBorder-1;
    }


    private void swap(int k, int m) {
        int b = test[k];
        test[k] = test[m];
        test[m] = b;
    }

    public int firstMissingPositive(int[] nums) {
        if(nums.length == 0) return 1;
        int min = Integer.MAX_VALUE;

        for(int i=0; i < nums.length; i++) if(nums[i] > 0 && nums[i] < min) min = nums[i];

        if(min > 1) return 1;

        int index = 0;

        while(index < nums.length && nums[index] != index && nums[index]>0){

            if( nums[nums[index]-1] > nums.length) continue;
            int tmp = nums[nums[index]-1];
            nums[nums[index]-1] = nums[index];
            index = tmp;
        }

        for(int i=0; i < nums.length; i++){
            if (nums[i]-1 != i) return i+1;
        }

        return nums.length +1;
    }


    public static void main(String[] args){

        FirstMissingPos fmp = new FirstMissingPos();

        System.out.print(fmp.firstMissingPositive(new int[]{2,1}));
    }
}
