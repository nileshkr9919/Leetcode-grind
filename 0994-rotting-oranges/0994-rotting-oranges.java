class Solution {
    public int orangesRotting(int[][] grid) {
        Deque<int[]> queue = new ArrayDeque<>();
        int fresh = 0;

        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j] == 2) {
                    queue.add(new int[]{i,j});
                } else if(grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int minutes = 0;

        int[] rowDir = new int[]{0,0,-1,1};
        int[] colDir = new int[]{-1,1,0,0};

        while(!queue.isEmpty()) {
            int size = queue.size();
            boolean rotted = false;

            for(int i=0;i<size;i++) {
                int[] cell = queue.poll();

                for(int dir = 0;dir<4;dir++) {
                    int nr = cell[0] + rowDir[dir];
                    int nc = cell[1] + colDir[dir];

                    if(nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        rotted = true;
                        fresh--;
                        queue.add(new int[]{nr,nc});
                    }
                }
            }

            if(rotted) minutes++;
        }

        return fresh == 0 ? minutes : -1;
    }
}