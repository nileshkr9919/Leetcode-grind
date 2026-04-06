class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];

            if (!map.containsKey(b)) {
                map.put(b, new ArrayList<>());
            }
            map.get(b).add(a);
        }

        int[] state = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (dfs(i, map, state)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int course, HashMap<Integer, List<Integer>> graph, int[] state) {
        if (state[course] == 1)
            return true;
        if (state[course] == 2)
            return false;

        state[course] = 1;

        if (graph.containsKey(course)) {
            List<Integer> neighbors = graph.get(course);
            for (int neighbor : neighbors) {
                if (dfs(neighbor, graph, state)) {
                    return true;
                }
            }
        }

        state[course] = 2;
        return false;
    }
}