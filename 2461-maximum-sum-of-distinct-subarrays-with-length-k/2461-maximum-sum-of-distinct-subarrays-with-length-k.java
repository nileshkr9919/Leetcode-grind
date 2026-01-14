public class Solution {
    public Long maximumSubarraySum(int[] nums, Integer k) {
        // Your code goes here

        if(nums == null || nums.length == 0 || k == 0) return 0L;

        HashSet<Integer> seen = new HashSet<>();
        int start = 0;
        Long sum = 0L, maxSum = 0L;

        for(int end = 0; end < nums.length; end++) {
            while(seen.contains(nums[end]) || end - start + 1 > k) {
                sum -= nums[start];
                seen.remove(nums[start]);
                start++;
            }
            seen.add(nums[end]);
            sum += nums[end];
            if (end - start + 1 == k) {
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }
}