class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLen = 0, windowSum = 0;

        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            windowSum += nums[i] == 0 ? -1 : 1;

            if (map.containsKey(windowSum)) {
                maxLen = Math.max(maxLen, i - map.get(windowSum));
            } else {
                map.put(windowSum, i);
            }
        }

        return maxLen;
    }
}