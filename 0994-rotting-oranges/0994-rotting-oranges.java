class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int fresh = 0;

        Deque<int[]> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[] { i, j });
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0)
            return 0;

        int[] rowDir = new int[] { 0, 0, -1, 1 };
        int[] colDir = new int[] { -1, 1, 0, 0 };

        int minutes = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rotted = false;

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();

                for (int d = 0; d < 4; d++) {
                    int nr = curr[0] + rowDir[d];
                    int nc = curr[1] + colDir[d];

                    if (nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        queue.add(new int[] { nr, nc });
                        fresh--;
                        rotted = true;
                    }
                }
            }

            if (rotted)
                minutes++;
        }

        return fresh == 0 ? minutes : -1;
    }
}