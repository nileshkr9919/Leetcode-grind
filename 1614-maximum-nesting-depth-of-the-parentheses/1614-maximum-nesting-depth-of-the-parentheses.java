class Solution {
    public int maxDepth(String s) {
        int len = 0, maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
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