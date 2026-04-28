class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);

        int median = nums[nums.length / 2];
        int ops = 0;

        for(int num : nums) {
            ops += Math.abs(num - median);
        }

        return ops;
    }
}