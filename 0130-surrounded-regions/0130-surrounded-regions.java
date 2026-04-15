class Solution {
    public void solve(char[][] board) {
        Queue<int[]> queue = new LinkedList<>();
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (((j == 0 || j == n - 1) || (i == 0 || i == m - 1)) && board[i][j] == 'O') {
                    queue.add(new int[] { i, j });
                }
            }
        }

        int[] rowDir = new int[] { 0, 0, -1, 1 };
        int[] colDir = new int[] { -1, 1, 0, 0 };

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();

            board[cell[0]][cell[1]] = 'Z';

            for (int dir = 0; dir < 4; dir++) {
                int nr = cell[0] + rowDir[dir];
                int nc = cell[1] + colDir[dir];

                if (nr >= 0 && nc >= 0 && nr < m && nc < n && board[nr][nc] == 'O') {
                    board[nr][nc] = 'Z';
                    queue.add(new int[]{nr,nc});
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                // if (board[i][j] == 'Z') {
                //     board[i][j] = 'O';
                // }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // if (board[i][j] == 'O') {
                //     board[i][j] = 'X';
                // }
                if (board[i][j] == 'Z') {
                    board[i][j] = 'O';
                }
            }
        }
    }
}