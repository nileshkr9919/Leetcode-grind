class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        for (int[] preq : prerequisites) {
            int u = preq[0];
            int v = preq[1];

            graph.get(v).add(u);
            indegree[u]++;
        }

        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);

            for (int nei : graph.get(node)) {
                indegree[nei]--;
                if (indegree[nei] == 0) {
                    queue.add(nei);
                }
            }
        }

        return result.size() == numCourses ? result.stream()
                .mapToInt(Integer::intValue)
                .toArray() : new int[]{};
    }

    // private boolean dfs(List<List<Integer>> graph, int course, int[] state, List<Integer> res) {
    //     if (state[course] == 2) {
    //         return true;
    //     }
    //     if (state[course] == 1) {
    //         return false;
    //     }
    //     state[course] = 1;

    //     for (int nei : graph.get(course)) {
    //         if (!dfs(graph, nei, state, res)) {
    //             return false;
    //         }
    //     }
    //     state[course] = 2;
    //     res.add(course);
    //     return true;
    // }
}