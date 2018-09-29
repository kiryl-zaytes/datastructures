package problems.backtracking;

/**
 * Created by kiryl_zayets on 9/28/18.
 */
public class WordSearch {

    boolean[][] visited;

    public boolean exist(char[][] board, String word) {

        visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if ((board[i][j] == word.charAt(0) &&
                        findLetter(board, word, 0, i, j))) {
                    return true;
                }
            }
        }
        return false;
    }


    public boolean isCorrectMove(char[][] board, int i, int j, char c) {
        if (i < 0 || j < 0 || i >= board.length || j >=board[i].length ||
                visited[i][j]) return false;

        if (c == board[i][j]) return true;

        return false;
    }


    public boolean findLetter(char[][] board,
            String word,
            int c,
            int i,
            int j) {

        if (c == word.length()) {
            return true;
        }

        if (!isCorrectMove(board, i, j, word.charAt(c))) return false;


        visited[i][j] = true;

        if (findLetter(board, word, c+1, i - 1, j) ||
                findLetter(board, word, c+1, i + 1, j) ||
                findLetter(board, word, c+1, i, j - 1) ||
                findLetter(board, word, c+1, i, j + 1)) return true;

        visited[i][j] = false;

        return false;
    }


    public static void main(String[] args) {

        WordSearch search = new WordSearch();
        System.out.print(search.exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}}, "ABCB"));
    }


}

