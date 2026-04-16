class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];

            graph.get(u).add(new int[] { v, w });
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[] { 0, k });

        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0], node = curr[1];

            if (cost > dist[node])
                continue; // stale entry

            for (int[] nei : graph.get(node)) {
                int nextCost = cost + nei[1];
                if (nextCost < dist[nei[0]]) {
                    dist[nei[0]] = nextCost;
                    pq.offer(new int[] { nextCost, nei[0] });
                }
            }
        }

        int maxDist = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                return -1; // unreachable node
            maxDist = Math.max(maxDist, dist[i]);
        }
        return maxDist;
    }
}