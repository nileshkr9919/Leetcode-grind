class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] graph = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++)
            graph[i] = new ArrayList<>();

        for (int[] time : times) {
            int u = time[0], v = time[1], w = time[2];

            graph[u].add(new int[] { v, w });
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        queue.offer(new int[] { 0, k });
        dist[k] = 0;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            int cost = curr[0], node = curr[1];

            if (cost > dist[node]) {
                continue;
            }

            for (int[] nei : graph[node]) {
                int nextCost = cost + nei[1];

                if (nextCost < dist[nei[0]]) {
                    dist[nei[0]] = nextCost;
                    queue.offer(new int[] { nextCost, nei[0] });
                }
            }
        }

        int maxCost = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                return -1;
            maxCost = Math.max(maxCost, dist[i]);
        }

        return maxCost;
    }
}