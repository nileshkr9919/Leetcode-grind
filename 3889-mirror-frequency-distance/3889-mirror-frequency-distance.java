class Solution {
    public int mirrorFrequency(String s) {
        char[] letters = new char[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
                'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
        char[] digits = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

        int sum = 0;

        int[] freq = new int[128];
        boolean[] visited = new boolean[128];

        // frequency count
        for (char ch : s.toCharArray()) {
            freq[ch]++;
        }

        for (char ch : s.toCharArray()) {
            if (visited[ch]) continue;

            char mirror = '\0';

            if (Character.isLetter(ch)) {
                mirror = letters[25 - (ch - 97)];
            } else if (Character.isDigit(ch)) {
                mirror = digits[9 - (ch - 48)];
            }

            int f1 = freq[ch];
            int f2 = freq[mirror];

            sum += Math.abs(f1 - f2);

            visited[ch] = true;
            visited[mirror] = true;
        }

        return sum;
    }
}