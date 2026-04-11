class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        Deque<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[] { i, j });
                } else {
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[] rDir = new int[] { 0, 0, -1, 1 };
        int[] cDir = new int[] { -1, 1, 0, 0 };

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int k = 0; k < size; k++) {
                int[] cell = queue.poll();
                int i = cell[0];
                int j = cell[1];

                for (int dir = 0; dir < 4; dir++) {
                    int nr = i + rDir[dir];
                    int nc = j + cDir[dir];

                    if (nr >= 0 && nc >= 0 && nr < m && nc < n) {
                        if(mat[nr][nc] > mat[i][j] + 1) {
                            mat[nr][nc] = mat[i][j] + 1;
                            queue.add(new int[]{nr,nc}); 
                        }
                    }
                }
            }

        }

        return mat;
    }
}