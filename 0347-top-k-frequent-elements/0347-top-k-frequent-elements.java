class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums)
            freq.put(n, freq.getOrDefault(n, 0) + 1);

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[1] - b[1]
        );

        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            pq.add(new int[]{e.getKey(), e.getValue()});
            if (pq.size() > k) pq.poll();
        }

        int[] ans = new int[k];
        int i = 0;
        while (!pq.isEmpty()) {
            ans[i++] = pq.poll()[0];
        }
        return ans;
    }
}