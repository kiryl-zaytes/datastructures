package problems.array;

/**
 * Created by kiryl_zayets on 10/10/18.
 */
public class FirstMissingPos {

    int[] test;

    public int getMissingPos(int[] test) {
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


    public static void main(String[] args){

        FirstMissingPos fmp = new FirstMissingPos();

        System.out.print(fmp.getMissingPos(new int[]{0,1,2}));
    }
}
