package datastructures;

/**
 * Created by kiryl_zayets on 1/10/19.
 */
public class TicTacToe {

    int[] rows;
    int[] cols;
    int diagonal = 0;
    int antidiagonal = 0;
    int size = 0;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
        size = n;
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {

        int playWeight = (player == 1)? 1 : -1;
        rows[row]+=playWeight;
        cols[col]+=playWeight;

        if (col == row) diagonal+=playWeight;
        if (col == cols.length - row -1) antidiagonal+=playWeight;

        if (rows[row] == size || cols[col] == size || diagonal == size || antidiagonal == size) return 1;
        if (rows[row] == -size || cols[col] == -size || diagonal == -size || antidiagonal == -size) return 2;

        return 0;
    }

}
