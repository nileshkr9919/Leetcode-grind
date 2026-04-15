class Solution {
    private int[] rowDir = new int[] { 0, 0, -1, 1 };
    private int[] colDir = new int[] { -1, 1, 0, 0 };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        Queue<int[]> pacificCells = new LinkedList<>();
        Queue<int[]> atlanticCells = new LinkedList<>();

        boolean[][] pacificVisited = new boolean[m][n];
        boolean[][] atlanticVisited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            pacificVisited[i][0] = true;
            pacificCells.add(new int[] { i, 0 });
            atlanticVisited[i][n - 1] = true;
            atlanticCells.add(new int[] { i, n - 1 });
        }

        for (int j = 0; j < n; j++) {
            pacificVisited[0][j] = true;
            pacificCells.add(new int[] { 0, j });
            atlanticVisited[m - 1][j] = true;
            atlanticCells.add(new int[] { m - 1, j });
        }

        bfs(pacificCells, heights, pacificVisited);
        bfs(atlanticCells, heights, atlanticVisited);

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacificVisited[i][j] && atlanticVisited[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }

    private void bfs(Queue<int[]> queue, int[][] heights, boolean[][] visited) {
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];

            for (int dir = 0; dir < 4; dir++) {
                int nr = r + rowDir[dir];
                int nc = c + colDir[dir];

                if (nr >= 0 && nc >= 0 && nr < heights.length && nc < heights[0].length && !visited[nr][nc]) {
                    if (heights[nr][nc] >= heights[r][c]) {
                        visited[nr][nc] = true;
                        queue.add(new int[] { nr, nc });
                    }
                }
            }
        }
    }
}