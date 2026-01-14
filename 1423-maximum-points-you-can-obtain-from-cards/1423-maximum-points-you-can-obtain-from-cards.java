public class Solution {
    public int maxScore(int[] cards, int k) {
        // Your code goes here
        int windowSum = 0, maxSum = Integer.MIN_VALUE;

        for (int start = 0; start < k; start++) {
            windowSum += cards[start];
        }

        maxSum = windowSum;

        int pivot = k - 1;
        for (int right = cards.length - 1; right >= (cards.length - k); right--) {
            windowSum -= cards[pivot--];
            ;
            windowSum += cards[right];
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }
}