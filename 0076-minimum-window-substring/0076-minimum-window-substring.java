import java.util.HashMap;

class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> tFreq = new HashMap<>();

        for (char ch : t.toCharArray()) {
            tFreq.put(ch, tFreq.getOrDefault(ch, 0) + 1);
        }

        int need = tFreq.size(), have = 0;
        int[] res = new int[] { -1, -1 };
        int left = 0, minLen = Integer.MAX_VALUE;
        HashMap<Character, Integer> sFreq = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            sFreq.put(ch, sFreq.getOrDefault(ch, 0) + 1);

            if (tFreq.containsKey(ch) && tFreq.get(ch).equals(sFreq.get(ch))) {
                have++;
            }

            while (have == need) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    res[0] = left;
                    res[1] = right;
                }
                char ch2 = s.charAt(left);
                sFreq.put(ch2, sFreq.get(ch2) - 1);
                if (tFreq.containsKey(ch2) && sFreq.get(ch2) < tFreq.get(ch2)) {
                    have--;
                }
                left++;
            }
        }

        return res[0] == -1 ? "" : s.substring(res[0], res[1] + 1);
    }
}