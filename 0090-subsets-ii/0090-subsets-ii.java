class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<Integer>(), res);
        return res;
    }

    private void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> res) {
        res.add(new ArrayList<Integer>(current));

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1])
                continue;
            current.add(nums[i]);
            backtrack(nums, i + 1, current, res);
            current.removeLast();
        }
    }
}