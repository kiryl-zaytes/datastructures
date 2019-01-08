package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kiryl_zayets on 1/4/19.
 */
public class RoomsAndKeys {



    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        boolean[] visited = new boolean[rooms.size()];
        helper(rooms, visited, 0);

        for(int i=0; i < visited.length; i++){
            if (!visited[i]) return false;
        }
        return true;
    }


    private void helper(List<List<Integer>> rooms, boolean[] visited, int pos){
        if (visited[pos]) return;
        ArrayList<Integer> keys = (ArrayList<Integer>) rooms.get(pos);
        visited[pos] = true;
        for (Integer k : keys) helper(rooms, visited, k);
    }

}
