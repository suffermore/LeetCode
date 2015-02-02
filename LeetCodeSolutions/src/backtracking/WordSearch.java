package backtracking;

public class WordSearch {
	public boolean exist(char[][] board, String word) {
        if (board == null |  board.length == 0) {
            return false;
        }
        if (word.length() == 0) {
            return true;
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean rst = find(board, word, i, j, 0);
                    if (rst) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    private boolean find(char[][] board, String word, int i, int j, int pos) {
        if (pos == word.length()) {
            return true;
        }
        
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word.charAt(pos)) {
            return false;
        } else {
            board[i][j] = '#';
            boolean rst = find(board, word, i + 1, j, pos + 1) || find(board, word, i, j + 1, pos + 1) || find(board, word, i - 1, j, pos + 1) || find(board, word, i, j - 1, pos + 1);
            
            board[i][j] = word.charAt(pos);
            return rst;
        }
    }
    
    public static void main(String[] args) {
		WordSearch w = new WordSearch();
		char[][] board = {{'a', 'b'}};
		if (w.exist(board, "ba")) {
			System.out.println("True");
		} else {
			System.out.println("False");
		}
	}
}
