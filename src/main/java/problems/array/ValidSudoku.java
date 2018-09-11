package problems.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by kiryl_zayets on 9/10/18.
 */
public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {

        if (board.length < 9 && board[0].length < 9) return false;

        Set<String> unique = new HashSet<String>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char c = board[i][j];

                if (c != '.') {
                    if (!unique.add("row" + i + board[i][j])) return false;
                    if (!unique.add("col" + j + board[i][j])) return false;
                    if (!unique.add("quadrant" + i / 3 +"-"+board[i][j] +"-"+j / 3))
                        return false;
                }
            }

        }

        return true;

    }


}
