class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);

        int i = 0;

        String first = strs[0];
        String last = strs[strs.length - 1];

        while (i < first.length() && i < last.length() && first.charAt(i) == last.charAt(i)) {
            i++;
        }

        return first.substring(0, i);
    }
}