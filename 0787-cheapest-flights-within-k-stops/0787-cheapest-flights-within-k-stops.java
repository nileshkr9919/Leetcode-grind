class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        
        for (int[] f : flights) graph.get(f[0]).add(new int[]{f[1], f[2]});

        // dist[node][stops] = cheapest cost to reach node using exactly 'stops' stops
        int[][] dist = new int[n][k + 2];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        dist[src][0] = 0;

        // PQ: {cost, node, stops}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, src, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0], node = curr[1], stops = curr[2];

            if (node == dst) return cost;
            if (stops > k) continue;

            for (int[] nei : graph.get(node)) {
                int nextCost = cost + nei[1];
                int nextStops = stops + 1;
                if (nextCost < dist[nei[0]][nextStops]) {
                    dist[nei[0]][nextStops] = nextCost;
                    pq.offer(new int[]{nextCost, nei[0], nextStops});
                }
            }
        }
        return -1;
    }
}