class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }

        int[] state = new int[numCourses];
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            if (dfs(graph, i, state, result)) {
                return new int[0];
            }
        }

        Collections.reverse(result);

        int[] ans = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }

    private boolean dfs(List<List<Integer>> graph, int i, int[] state, List<Integer> result) {
        if (state[i] == 1) {
            return true;
        }
        if (state[i] == 2) {
            return false;
        }
        state[i] = 1;

        List<Integer> neighbors = graph.get(i);
        for (int dep : neighbors) {
            if (dfs(graph, dep, state, result)) {
                return true;
            }
        }

        state[i] = 2;
        result.add(i);
        return false;
    }
}