class Solution {
    public void solve(char[][] board) {
        // Deque<int[]> queue = new ArrayDeque<>();

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][n - 1] == 'O') {
                dfs(board, i, n - 1);
            }
        }

        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                dfs(board, 0, j);
            }
            if (board[m - 1][j] == 'O') {
                dfs(board, m - 1, j);
            }
        }

        // int[] rowDir = new int[] { 0, 0, -1, 1 };
        // int[] colDir = new int[] { -1, 1, 0, 0 };

        // while (!queue.isEmpty()) {
        //     int[] cell = queue.poll();

        //     int r = cell[0];
        //     int c = cell[1];

        //     board[r][c] = 'Z';

        //     for (int dir = 0; dir < 4; dir++) {
        //         int nr = r + rowDir[dir];
        //         int nc = c + colDir[dir];

        //         if (nr >= 0 && nr < m && nc >= 0 && nc < n && board[nr][nc] == 'O') {
        //             board[nr][nc] = 'Z';
        //             queue.add(new int[] { nr, nc });
        //         }
        //     }
        // }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'Z') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int r, int c) {
        if (r < 0 || c < 0 || r >= board.length ||
                c >= board[0].length || board[r][c] != 'O')
            return;

        board[r][c] = 'Z';
        dfs(board, r + 1, c);
        dfs(board, r - 1, c);
        dfs(board, r, c + 1);
        dfs(board, r, c - 1);
    }
}