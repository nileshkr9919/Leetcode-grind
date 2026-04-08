class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] prerequisite : prerequisites) {
            if (!graph.containsKey(prerequisite[1])) {
                graph.put(prerequisite[1], new ArrayList<>());
            }
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }
        int[] state = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (dfs(graph, i, state)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(HashMap<Integer, List<Integer>> graph, int i, int[] state) {
        if (state[i] == 1) {
            return true;
        }
        if (state[i] == 2) {
            return false;
        }
        state[i] = 1;
        if (graph.containsKey(i)) {
            List<Integer> neighbors = graph.get(i);
            for (int dep : neighbors) {
                if (dfs(graph, dep, state)) {
                    return true;
                }
            }
        }
        state[i] = 2;
        return false;
    }
}