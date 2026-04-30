class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[] currentInterval = intervals[0];

        List<int[]> res = new ArrayList<>();

        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];

            if (interval[0] <= currentInterval[1]) {
                currentInterval[1] = Math.max(currentInterval[1], interval[1]);
            } else {
                res.add(currentInterval);
                currentInterval = interval;
            }
        }
        res.add(currentInterval);

        return res.toArray(new int[res.size()][]);
    }
}