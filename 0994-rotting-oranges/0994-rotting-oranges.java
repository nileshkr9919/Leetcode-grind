class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Deque<int[]> queue = new LinkedList<>();
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
            boolean rotted = false;
            int size = queue.size();

            for (int k = 0; k < size; k++) {
                int[] cell = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int nr = cell[0] + rowDir[i];
                    int nc = cell[1] + colDir[i];

                    if (nr >= 0 && nc >= 0 && nr < m && nc < n) {
                        if (grid[nr][nc] == 1) {
                            grid[nr][nc] = 2;
                            rotted = true;
                            fresh--;
                            queue.add(new int[] { nr, nc });
                        }
                    }
                }
            }
            if (rotted) {
                minutes++;
            }
        }

        return fresh == 0 ? minutes : -1;
    }
}