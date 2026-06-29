class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int res = 0;

        for (String s : patterns) {
            if (word.indexOf(s) != -1) {
                res++;
            }
        }

        return res;
    }
}