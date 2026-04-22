import java.util.HashMap;

class Solution {
    public int characterReplacement(String s, int k) {
        // Pattern windowLen - maxFreq <= k

        int left = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int maxFreq = 0;
        int res = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            maxFreq = Math.max(maxFreq, map.get(ch));

            while ((right - left + 1) - maxFreq > k) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                left++;
            }
            res = Math.max(res, right - left + 1);

        }

        return res;
    }
}