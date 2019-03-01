package problems.array.matrix;

import java.util.ArrayList;

/**
 * Created by kiryl_zayets on 2/21/19.
 */
public class SurroundedRegions {

    boolean borderReached = false;

    public void solve(char[][] board) {
        boolean[][] boolBoard = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    ArrayList<Coord> erase = new ArrayList<>();
                    walker(board, i, j, erase, boolBoard);
                    if (!borderReached) for (Coord c : erase) board[c.x][c.y] = 'X';
                    borderReached = false;
                }
            }
        }

    }

    class Coord {
        int x;
        int y;

        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    private void walker(char[][] board,
            int i,
            int j,
            ArrayList<Coord> erase,
            boolean[][] booleans) {

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length ||
                board[i][j] == 'X' || booleans[i][j]) return;
        if ((i == 0 || j == 0 || i == board.length-1 || j == board[0].length-1) &&
                board[i][j] != 'X') borderReached = true;

        erase.add(new Coord(i, j));
        booleans[i][j] = true;
        walker(board, i + 1, j, erase, booleans);
        walker(board, i - 1, j, erase, booleans);
        walker(board, i, j + 1, erase, booleans);
        walker(board, i, j - 1, erase, booleans);
    }


    public static void main(String[] args) {
        SurroundedRegions maxAreaOfIsland = new SurroundedRegions();
        maxAreaOfIsland.solve(new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'O'},
                {'X', 'O', 'X', 'X'}});
    }

}
