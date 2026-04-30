class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int[] currentInterval = intervals[0];
        int count = 0;

        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];

            if (interval[0] < currentInterval[1]) {
                count++;
            } else {
                currentInterval = intervals[i];
            }
        }

        return count - 1;
    }
}