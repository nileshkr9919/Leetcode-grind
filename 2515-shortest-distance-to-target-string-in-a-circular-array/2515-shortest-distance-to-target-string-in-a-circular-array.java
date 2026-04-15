class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        if (words[startIndex].equals(target))
            return 0;
        int n = words.length;
        for (int i = 0; i < n; i++) {
            int next = (startIndex + i + 1) % n;
            int prev = (startIndex - i - 1 + n) % n;

            if (words[next].equals(target) || words[prev].equals(target)) {
                return i + 1;
            }

        }

        return -1;
    }
}