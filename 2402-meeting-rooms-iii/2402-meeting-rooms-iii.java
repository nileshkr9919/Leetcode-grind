class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> freeRooms = new PriorityQueue<>();
        for (int i = 0; i < n; i++)
            freeRooms.offer(i);

        PriorityQueue<long[]> busyRooms = new PriorityQueue<>(
                (a, b) -> a[0] == b[0] ? Long.compare(a[1], b[1]) : Long.compare(a[0], b[0]));

        int[] count = new int[n];

        for (int[] meeting : meetings) {
            long start = meeting[0];
            long end = meeting[1];

            long diff = end - start;

            while (!busyRooms.isEmpty() && busyRooms.peek()[0] <= start) {
                freeRooms.offer((int)busyRooms.poll()[1]);
            }

            if (!freeRooms.isEmpty()) {
                int room = freeRooms.poll();
                busyRooms.offer(new long[] { end, room });
                count[room]++;
            } else {
                long[] earliest = busyRooms.poll();
                long room = earliest[1];
                long newEnd = earliest[0] + diff;
                busyRooms.offer(new long[] { newEnd, room });
                count[(int)room]++;
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            if (count[i] > count[res]) {
                res = i;
            }
        }

        return res;
    }
}