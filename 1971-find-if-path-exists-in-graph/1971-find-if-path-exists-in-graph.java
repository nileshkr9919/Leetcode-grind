class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination)
            return true;

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        System.out.println(graph);

        boolean[] visited = new boolean[n];

        return dfs(graph, source, destination, visited);
    }

    private boolean dfs(List<List<Integer>> graph, int src, int dest, boolean[] visited) {
        List<Integer> neighbors = graph.get(src);
        visited[src] = true;

        for (int n : neighbors) {
            if (n == dest) {
                return true;
            }
            if (!visited[n]) {
                if (dfs(graph, n, dest, visited))
                    return true;
            }
        }

        return false;
    }
}