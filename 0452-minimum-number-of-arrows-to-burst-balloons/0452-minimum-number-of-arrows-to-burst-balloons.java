class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1])
);
        int arrows = 1;
        int[] arrowPos = points[0];

        for (int i = 1; i < points.length; i++) {
            int[] curr = points[i];

            if (curr[0] > arrowPos[1]) {
                arrowPos = curr;
                arrows++;
            }
        }

        return arrows;
    }
}