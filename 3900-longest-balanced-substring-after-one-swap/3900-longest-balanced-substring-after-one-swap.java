class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int totalZeros = 0;
        for (char c : s.toCharArray()) {
            if (c == '0')
                totalZeros++;
        }
        int totalOnes = n - totalZeros;

        int[] first = new int[2 * n + 5];
        int[] last = new int[2 * n + 5];
        Arrays.fill(first, -1);
        Arrays.fill(last, -1);

        int balance = 0;
        int offset = n + 2;
        first[balance + offset] = -1;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0')
                balance++;
            else
                balance--;

            if (first[balance + offset] == -1) {
                first[balance + offset] = i;
            }
            last[balance + offset] = i;
        }

        int maxLen = 0;

        // Check all balances
        for (int bal = -n; bal <= n; bal++) {
            int idx = bal + offset;
            if (first[idx] != -1 && last[idx] != -1) {
                int len = last[idx] - first[idx];
                if (len % 2 == 0 && len > maxLen) {
                    maxLen = len;
                }
            }
        }

        // Check diff = 2
        for (int bal = -n; bal <= n - 2; bal++) {
            int idx1 = bal + offset;
            int idx2 = bal + 2 + offset;
            if (first[idx1] != -1 && last[idx2] != -1) {
                int len = last[idx2] - first[idx1];
                if (len % 2 == 0) {
                    int half = len / 2;
                    if (totalOnes > half - 1 && len > maxLen) {
                        maxLen = len;
                    }
                }
            }
        }

        // Check diff = -2
        for (int bal = -n + 2; bal <= n; bal++) {
            int idx1 = bal + offset;
            int idx2 = bal - 2 + offset;
            if (first[idx1] != -1 && last[idx2] != -1) {
                int len = last[idx2] - first[idx1];
                if (len % 2 == 0) {
                    int half = len / 2;
                    if (totalZeros > half - 1 && len > maxLen) {
                        maxLen = len;
                    }
                }
            }
        }

        return maxLen;
    }
}