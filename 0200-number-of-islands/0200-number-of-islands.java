class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    bfs(grid, i, j);
                }
            }
        }

        return count;
    }

    private void bfs(char[][] grid, int i, int j) {
        int[] rowDir = new int[]{0,0,1,-1};
        int[] colDir = new int[]{-1,1,0,0};

        Deque<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i,j});

        grid[i][j] = '0';

        while(!queue.isEmpty()) {
            int cell[] = queue.poll();

            for(int dir = 0;dir<4;dir++) {
                int nr = cell[0] + rowDir[dir];
                int nc = cell[1] + colDir[dir];

                if(nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == '1') {
                    grid[nr][nc] = '0';
                    queue.add(new int[]{nr,nc});
                }
            }
        }
    }
}