class Solution {
    public int[] countOppositeParity(int[] nums) {
        int[] answer = new int[nums.length];
        int totalEven = 0, totalOdd = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0)
                totalEven++;
            else
                totalOdd++;
        }

        int seenOdd = 0, seenEven = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                answer[i] = totalOdd - seenOdd;
                seenEven++;
            } else {
                answer[i] = totalEven - seenEven;
                seenOdd++;
            }
        }

        return answer;
    }
}