class Solution {
    public int orangesRotting(int[][] grid) {
        Deque<int[]> queue = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[] { i, j });
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int minutes = 0;

        int[] rowDir = new int[] { 0, 0, -1, 1 };
        int[] colDir = new int[] { -1, 1, 0, 0 };

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rotted = false;

            for (int k = 0; k < size; k++) {
                int[] curr = queue.poll();
                int r = curr[0];
                int c = curr[1];

                for (int dir = 0; dir < 4; dir++) {
                    int nr = r + rowDir[dir];
                    int nc = c + colDir[dir];

                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        fresh--;
                        rotted = true;
                        queue.add(new int[] { nr, nc });
                    }
                }
            }

            if (rotted) {
                minutes++;
            }
        }

        return fresh > 0 ? -1 : minutes;
    }
}