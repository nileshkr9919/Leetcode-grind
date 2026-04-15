class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int totalZeros = 0;
        for (char c : s.toCharArray())
            if (c == '0')
                totalZeros++;
        int totalOnes = n - totalZeros;

        Map<Integer, List<Integer>> positions = new HashMap<>();
        positions.put(0, new ArrayList<>());
        positions.get(0).add(-1);

        int balance = 0;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            balance += (s.charAt(i) == '0' ? 1 : -1);

            positions.computeIfAbsent(balance, k -> new ArrayList<>()).add(i);

            // Check diff = 0
            List<Integer> list0 = positions.get(balance);
            int first = list0.get(0);
            int len = i - first;
            if (len % 2 == 0 && len > maxLen)
                maxLen = len;

            // Check diff = 2
            List<Integer> list2 = positions.get(balance - 2);
            if (list2 != null) {
                // Need earliest that gives valid length
                int maxPossible = 2 * totalOnes + 2;
                for (int idx : list2) {
                    len = i - idx;
                    if (len > maxPossible)
                        continue;
                    if (len % 2 == 0) {
                        int half = len / 2;
                        if (totalOnes > half - 1 && len > maxLen) {
                            maxLen = len;
                        }
                    }
                }
            }

            // Check diff = -2
            List<Integer> list_2 = positions.get(balance + 2);
            if (list_2 != null) {
                int maxPossible = 2 * totalZeros + 2;
                for (int idx : list_2) {
                    len = i - idx;
                    if (len > maxPossible)
                        continue;
                    if (len % 2 == 0) {
                        int half = len / 2;
                        if (totalZeros > half - 1 && len > maxLen) {
                            maxLen = len;
                        }
                    }
                }
            }
        }

        return maxLen;
    }
}