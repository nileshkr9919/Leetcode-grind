class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] lastPos = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            lastPos[ch - 'a'] = i;
        }

        List<Integer> res = new ArrayList<>();

        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            end = Math.max(end, lastPos[ch - 'a']);
            if (end == i) {
                res.add(end - start + 1);
                start = i + 1;
            }
        }

        return res;
    }
}