class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, maxLen = 0;
        HashSet<Character> set = new HashSet<>();

        for (int right = left; right < s.length(); right++) {
            char ch = s.charAt(right);
            while (set.contains(ch)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(ch);
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}