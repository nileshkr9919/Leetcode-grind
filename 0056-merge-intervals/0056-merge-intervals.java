class Solution {
    public int[][] merge(int[][] intervals) {
        // Sort by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // Loop over intervals and merge intervals with start time less than end time of prev interval

        List<int[]> res = new ArrayList<>();

        int[] currentInterval = new int[] { intervals[0][0], intervals[0][1] };

        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];

            if (interval[0] <= currentInterval[1]) {
                currentInterval[1] = Math.max(interval[1], currentInterval[1]);
            } else {
                res.add(currentInterval);
                currentInterval = interval;
            }
        }

        res.add(currentInterval);

        return res.toArray(new int[res.size()][]);
    }
}