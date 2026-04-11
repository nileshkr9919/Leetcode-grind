class Solution {
    public int minimumDistance(int[] nums) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<Integer>());
            }
            map.get(nums[i]).add(i);
        }

        int minDis = Integer.MAX_VALUE;

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> indices = entry.getValue();
            if (indices.size() < 3)
                continue;

            for (int i = 2; i < indices.size(); i++) {
                int dist = 2 * (indices.get(i) - indices.get(i - 2));
                minDis = Math.min(minDis, dist);
            }
        }

        return minDis == Integer.MAX_VALUE ? -1 : minDis;
    }
}
