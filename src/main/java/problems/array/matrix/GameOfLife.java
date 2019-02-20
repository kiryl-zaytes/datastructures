package problems.array.matrix;

/**
 * Created by kiryl_zayets on 2/20/19.
 */
public class GameOfLife {

    public void gameOfLife(int[][] board) {
        int[][] moves = {{-1, 0}, {0,-1}, {1, 0}, {0, 1}, {-1,-1}, {1,1}, {-1, 1}, {1, -1}};

        for (int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                int alive = 0;
                for (int[] move : moves){
                    if (move[0]+i >=board.length || move[1]+j >= board[0].length || move[0]+i < 0 || move[1]+j < 0) continue;
                    if (board[move[0]+i][move[1]+j] == 1 || board[move[0]+i][move[1]+j] == 2) alive++;
                }

                if (board[i][j] == 0 && alive == 3) board[i][j] = 3;
                if (board[i][j] == 1 && (alive > 3 || alive < 2)) board[i][j] = 2;
            }
        }

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                board[i][j] = board[i][j] % 2;
            }
        }

    }

}
