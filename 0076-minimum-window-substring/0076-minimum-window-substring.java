class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> tFreq = new HashMap<>();

        for (char ch : t.toCharArray()) {
            tFreq.put(ch, tFreq.getOrDefault(ch, 0) + 1);
        }

        HashMap<Character, Integer> sFreq = new HashMap<>();
        int have = 0, need = tFreq.size();
        int left = 0;
        int[] res = { -1, -1 }; // result window indices
        int resLen = Integer.MAX_VALUE;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            sFreq.put(c, sFreq.getOrDefault(c, 0) + 1);

            // did this char satisfy a requirement?
            if (tFreq.containsKey(c) && sFreq.get(c).equals(tFreq.get(c)))
                have++;

            // shrink from left while window is valid
            while (have == need) {
                // record if smallest window
                if (right - left + 1 < resLen) {
                    resLen = right - left + 1;
                    res[0] = left;
                    res[1] = right;
                }
                // shrink
                char l = s.charAt(left);
                sFreq.put(l, sFreq.get(l) - 1);
                if (tFreq.containsKey(l) && sFreq.get(l) < tFreq.get(l))
                    have--;
                left++;
            }
        }

        return res[0] == -1 ? "" : s.substring(res[0], res[1] + 1);
    }
}