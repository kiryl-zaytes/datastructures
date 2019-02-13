package problems.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kiryl_zayets on 2/13/19.
 */
public class NQueen {

    int N = 0;
    int res = 0;

    public List<List<String>> solveNQueens(int n) {

        this.N = n;

        char[][] field = new char[n][n];

        for(int i=0; i < n; i++){
            for(int j=0; j<n; j++){
                field[i][j] = '.';
            }
        }
        List<List<String>> res = new ArrayList<>();
        backTrack(field, 0, res);
        return res;
    }


    private void backTrack(char[][] field, int col, List<List<String>> res){
        if (col == N) {
            construct(field, res);
            return;
        }

        for(int i=0; i < N; i++) {
            if (isCorrectPlace(field, i, col)) {
                field[i][col] = 'Q';
                backTrack(field, col + 1, res);
                field[i][col] = '.';
            }
        }
    }


    private void construct(char[][] field, List<List<String>> res){
        ArrayList<String> r = new ArrayList<>();
        for(int i=0; i < N; i++){
            String s = new String(field[i]);
            r.add(s);
        }
        res.add(r);
    }

    private boolean isCorrectPlace(char[][] field, int x, int y){

        for(int i=0; i < N; i++){
            for(int j=0; j <=y; j++){
                if ((field[i][j] == 'Q') && (j==y || i==x || x+y==i+j|| i+y == j+x)) return false;
            }
        }
        return true;
    }


    public static void main(String[] args){
        NQueen nq= new NQueen();
        nq.solveNQueens(4);
    }

}
