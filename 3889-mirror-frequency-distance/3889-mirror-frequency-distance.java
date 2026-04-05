class Solution {
    public int mirrorFrequency(String s) {
        char[] letters = new char[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
                'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
        char[] digits = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        int sum = 0;
        HashMap<Character, Integer> freqMap = new HashMap<>();
        HashMap<Character, Character> mirrorMap = new HashMap<>();

        for (char ch : s.toCharArray()) {
            char m = '\0';
            if (Character.isLetter(ch)) {
                m = letters[25 - (ch - 97)];
            } else if (Character.isDigit(ch)) {
                m = digits[9 - (ch - 48)];
            }
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
            mirrorMap.put(ch, m);
        }

        HashSet<Character> visited = new HashSet<>();

        for (Map.Entry<Character, Character> entry : mirrorMap.entrySet()) {
            char ch = entry.getKey();
            char mirror = entry.getValue();

            if (visited.contains(ch)) continue;

            int f1 = freqMap.getOrDefault(ch, 0);
            int f2 = freqMap.getOrDefault(mirror, 0);

            sum += Math.abs(f1 - f2);

            visited.add(ch);
            visited.add(mirror);
        }

        return sum;
    }
}