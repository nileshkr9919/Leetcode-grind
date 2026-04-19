class Solution {
    public boolean isBipartite(int[][] graph) {
        int count = 0;
        int n = graph.length;

        int[] visited = new int[n];

        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                if(!dfs(graph, i, visited, 1)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean dfs(int[][] graph, int node, int[] visited, int color) {
        visited[node] = color;

        for (int nei : graph[node]) {
            if (visited[nei] == 0) {
                if (!dfs(graph, nei, visited, -color))
                    return false;
            } else if (visited[nei] == color) {
                return false;
            }
        }

        return true;
    }
}