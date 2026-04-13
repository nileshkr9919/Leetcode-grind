class Solution {
    public void solve(char[][] board) {
        Deque<int[]> queue = new ArrayDeque<>();

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                queue.add(new int[] { i, 0 });
            }
            if (board[i][n - 1] == 'O') {
                queue.add(new int[] { i, n - 1 });
            }
        }

        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                queue.add(new int[] { 0, j });
            }
            if (board[m - 1][j] == 'O') {
                queue.add(new int[] { m - 1, j });
            }
        }

        int[] rowDir = new int[] { 0, 0, -1, 1 };
        int[] colDir = new int[] { -1, 1, 0, 0 };

        while (!queue.isEmpty()) {
            int size = queue.size();

            int[] cell = queue.poll();

            int r = cell[0];
            int c = cell[1];

            board[r][c] = 'Z';

            for (int dir = 0; dir < 4; dir++) {
                int nr = r + rowDir[dir];
                int nc = c + colDir[dir];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n && board[nr][nc] == 'O') {
                    board[nr][nc] = 'Z';
                    queue.add(new int[] { nr, nc });
                }
            }
        }

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
}