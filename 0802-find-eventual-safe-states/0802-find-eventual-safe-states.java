class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] state = new int[graph.length];
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < graph.length; i++) {
            if (dfs(graph, i, state)) {
                res.add(i);
            }
        }

        return res;
    }

    private boolean dfs(int[][] graph, int node, int[] state) {
        if (state[node] == 2) {
            return true;
        }
        if (state[node] == 1) {
            return false;
        }
        state[node] = 1;

        for (int n : graph[node]) {
            if (!dfs(graph, n, state)) {
                return false;
            }
        }

        state[node] = 2;
        return true;
    }
}