package array;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {
	
	public void solve(char[][] board) {
		if (board.length <= 2 || board[0].length <=2) {
			return ;
		}
		
		int rows = board.length;
		int cols = board[0].length;

		// For testing
		for (int i = 0; i< rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.print(" " + board[i][j]);
			}
			System.out.println(" ");
		}
		System.out.println(" ");
		
		//top side
		for (int i = 0; i < cols; i++) {
			if (board[0][i] == 'O') {
				board[0][i] = '#';
				dfs(board, 0, i, rows, cols);
			}
		}

		//bot side
		for (int i = 0; i < cols; i++) {
			if (board[rows - 1][i] == 'O') {
				board[rows - 1][i] = '#';
				dfs(board, rows - 1, i, rows, cols);
			}
		}

		//left side
		for (int i = 0; i < rows; i++) {
			if (board[i][0] == 'O') {
				board[i][0] = '#';
				dfs(board, i, 0, rows, cols);
			}
		}

		//right side
		for (int i = 0; i < rows; i++) {
			if (board[i][cols - 1] == 'O') {
				board[i][cols - 1] = '#';
				dfs(board, i, cols - 1, rows, cols);
			}
		}
		
		//restore '#' back to 'x'
		for (int i = 0; i< rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (board[i][j] == '#') {
					board[i][j] = 'O';
				} else if (board[i][j] == 'O') {
					board[i][j] = 'X';
				}
			}
		}
		
		//testing
		for (int i = 0; i< rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.print(" " + board[i][j]);
			}
			System.out.println(" ");
		}
    }

	private void dfs(char[][] board, int i, int j, int rows, int cols) {
		if (i > 1 && board[i - 1][j] == 'O') {
			board[i - 1][j] = '#';
			dfs(board, i - 1, j, rows, cols);
		}
		if (i < rows - 1 && board[i + 1][j] == 'O') {
			board[i + 1][j] = '#';
			dfs(board, i + 1, j, rows, cols);
		}
		if (j > 1 && board[i][j - 1] == 'O') {
			board[i][j - 1] = '#';
			dfs(board, i, j - 1, rows, cols);
		}
		if (j < cols - 1 && board[i][j + 1] == 'O') {
			board[i][j + 1] = '#';
			dfs(board, i, j + 1, rows, cols);
		}
	}
	
	//version II
	private static Queue<Integer> queue = null;
    private static char[][] board;
    private static int rows = 0;
    private static int cols = 0;

    public void solveII(char[][] board) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (board.length == 0 || board[0].length == 0) return;
        queue = new LinkedList<Integer>();
        board = board;
        rows = board.length;
        cols = board[0].length;

        for (int i = 0; i < rows; i++) { // **important**
            enqueue(i, 0);
            enqueue(i, cols - 1);
        }

        for (int j = 1; j < cols - 1; j++) { // **important**
            enqueue(0, j);
            enqueue(rows - 1, j);
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int x = cur / cols,
                y = cur % cols;

            if (board[x][y] == 'O') {
                board[x][y] = 'D';
            }

            enqueue(x - 1, y);
            enqueue(x + 1, y);
            enqueue(x, y - 1);
            enqueue(x, y + 1);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'D') board[i][j] = 'O';
                else if (board[i][j] == 'O') board[i][j] = 'X';
            }
        }

        queue = null;
        board = null;
        rows = 0;
        cols = 0;
    }

    public static void enqueue(int x, int y) {
        if (x >= 0 && x < rows && y >= 0 && y < cols && board[x][y] == 'O'){  
            queue.offer(x * cols + y);
        }
    }
	
	public static void main(String[] args) {
		char[][] board = {{'X','O','X','X'}, {'O','X','O','X'}, {'X','O','X','O'}, {'O','X','O','X'}};
		SurroundedRegions s = new SurroundedRegions();
		s.solve(board);
	}
}
