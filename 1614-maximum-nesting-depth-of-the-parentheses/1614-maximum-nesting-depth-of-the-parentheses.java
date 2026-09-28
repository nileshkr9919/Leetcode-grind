class Solution {
    public int maxDepth(String s) {
        int len = 0, maxLen = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                len++;
                maxLen = Math.max(len, maxLen);
            } else if (ch == ')') {
                len--;
            }
        }

        return maxLen;
    }
}