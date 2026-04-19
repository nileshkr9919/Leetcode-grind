class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] preq : prerequisites) {
            int u = preq[0];
            int v = preq[1];

            graph.get(v).add(u);
        }

        int[] state = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, i, state)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(List<List<Integer>> graph, int course, int[] state) {
        if (state[course] == 2) {
            return true;
        }
        if (state[course] == 1) {
            return false;
        }
        state[course] = 1;

        for (int nei : graph.get(course)) {
            if (!dfs(graph, nei, state)) {
                return false;
            }
        }
        state[course] = 2;
        return true;
    }
}