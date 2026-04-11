class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= edges.length; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);

            boolean[] visited = new boolean[edges.length + 1];

            if (dfs(graph, u, -1, visited)) {
                return edge;
            }
        }

        return new int[0];
    }

    private boolean dfs(List<List<Integer>> graph, int src, int dest, boolean[] visited) {
        if (visited[src])
            return true;
        visited[src] = true;

        for (int n : graph.get(src)) {
            if (n == dest) {
                continue;
            }
            if (dfs(graph, n, src, visited))
                return true;
        }

        return false;
    }
}