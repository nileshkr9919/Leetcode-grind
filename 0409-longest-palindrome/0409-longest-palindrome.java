class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int res = 0;
        boolean containsOdd = false;

        for (Map.Entry entry : map.entrySet()) {
            int val = (int) entry.getValue();
            if (val % 2 == 0) {
                res += val;
            } else {
                containsOdd = true;
                res += val - 1;
            }
        }

        return containsOdd ? res + 1 : res;
    }
}