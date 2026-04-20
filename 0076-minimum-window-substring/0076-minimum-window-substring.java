class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> tFreq = new HashMap<>();

        for (char ch : t.toCharArray()) {
            tFreq.put(ch, tFreq.getOrDefault(ch, 0) + 1);
        }

        HashMap<Character, Integer> sFreq = new HashMap<>();
        int have = 0, need = tFreq.size();
        int[] res = {-1,-1};
        int minRes = Integer.MAX_VALUE;
        int left = 0;

        for(int right=0;right<s.length();right++) {
            char ch = s.charAt(right);
            sFreq.put(ch, sFreq.getOrDefault(ch, 0) + 1);

            if(tFreq.containsKey(ch) && sFreq.get(ch).equals(tFreq.get(ch))) {
                have++;
            }

            while(have == need) {
                if(right - left + 1 < minRes) {
                    minRes = right - left + 1;
                    res[0] = left;
                    res[1] = right;
                }
                char l = s.charAt(left);
                sFreq.put(l, sFreq.get(l) - 1);
                if( tFreq.containsKey(l) && sFreq.get(l) < tFreq.get(l)) {
                    have--;
                } 
                left++;
            }
        }

        return res[0] == -1 ? "" : s.substring(res[0], res[1] + 1);

    }
}