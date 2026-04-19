class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, i, state, res)) {
                return new int[] {};
            }
        }

        Collections.reverse(res);

        int[] ans = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            ans[i] = res.get(i);
        }

        return ans;
    }

    private boolean dfs(List<List<Integer>> graph, int course, int[] state, List<Integer> res) {
        if (state[course] == 2) {
            return true;
        }
        if (state[course] == 1) {
            return false;
        }
        state[course] = 1;

        for (int nei : graph.get(course)) {
            if (!dfs(graph, nei, state, res)) {
                return false;
            }
        }
        state[course] = 2;
        res.add(course);
        return true;
    }
}