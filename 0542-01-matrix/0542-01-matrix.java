class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        Deque<int[]> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[] { i, j });
                } else {
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[] rowDir = new int[] { 0, 0, 1, -1 };
        int[] colDir = new int[] { -1, 1, 0, 0 };

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();

                int r = curr[0];
                int c = curr[1];

                for (int d = 0; d < 4; d++) {
                    int nr = r + rowDir[d];
                    int nc = c + colDir[d];

                    if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                        if (mat[nr][nc] > mat[r][c] + 1) {
                            mat[nr][nc] = mat[r][c] + 1;
                            queue.add(new int[] { nr, nc });
                        }
                    }
                }

            }

        }

        return mat;
    }
}