class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        Set<Integer> set = new HashSet<>();
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            max = Math.max(nums[i], max);
            min = Math.min(nums[i], min);

            set.add(nums[i]);
        }

        if (nums.length == max - min + 1)
            return new ArrayList<Integer>();

        for (int i = min; i <= max; i++) {
            if (!set.contains(i))
                res.add(i);
        }

        return res;
    }
}