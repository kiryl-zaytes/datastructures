package datastructures;

/**
 * Created by kiryl_zayets on 1/10/19.
 */
public class FindCelebrity {

    private boolean knows(int a, int b){
        return true;
    }

    public int findCelebrity(int n) {
        int cel = 0;

        for(int i=0; i < n; i++) if (knows(cel, i)) cel = i;
        for(int i=0; i < cel; i++) if (knows(cel, i)) return -1;
        for(int i=0; i < n; i++) if (!knows(i, cel)) return -1;

        return cel;

    }

}
