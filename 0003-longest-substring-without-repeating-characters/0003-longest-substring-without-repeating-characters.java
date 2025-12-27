class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxlen = 0, left = 0;

        HashSet<Character> set = new HashSet<>();

        for (int right = left; right < s.length(); right++) {
            char ch = s.charAt(right);
            if (set.contains(ch)) {
                while (set.contains(ch)) {
                    set.remove(s.charAt(left));
                    left++;
                }
            }
            set.add(ch);
            maxlen = Math.max(right - left + 1, maxlen);
        }

        return maxlen;
    }
}