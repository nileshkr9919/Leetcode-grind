class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();

        dfs(graph, 0, new ArrayList<>(), res);

        return res;
    }

    void dfs(int[][] graph, int node, List<Integer> path, List<List<Integer>> result) {
        path.add(node);

        if (node == graph.length - 1) {
            result.add(new ArrayList<>(path)); // save a COPY not reference
            path.remove(path.size() - 1); // backtrack
            return;
        }

        for (int nei : graph[node]) {
            dfs(graph, nei, path, result);
        }

        path.remove(path.size() - 1); // backtrack
    }
}