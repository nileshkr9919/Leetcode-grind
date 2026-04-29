class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        long total_gas = 0, total_cost = 0;

        for (int i = 0; i < gas.length; i++) {
            total_gas += gas[i];
            total_cost += cost[i];
        }

        if (total_gas < total_cost)
            return -1;

        long tank = 0;
        int start = 0;

        for (int right = 0; right < gas.length; right++) {
            tank += gas[right] - cost[right];
            if (tank < 0) {
                tank = 0;
                start = right + 1;
            }
        }

        return start;
    }
}