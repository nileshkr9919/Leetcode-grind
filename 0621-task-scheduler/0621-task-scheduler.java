class Solution {
    public int leastInterval(char[] tasks, int n) {
        int maxFreq = 0, maxCount = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (char ch : tasks) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            if (map.get(ch) > maxFreq) {
                maxFreq = map.get(ch);
                maxCount = 1;
            } else if (map.get(ch) == maxFreq) {
                maxCount++;
            }
            maxFreq = Math.max(maxFreq, map.get(ch));
        }

        return Math.max(tasks.length, (maxFreq - 1) * (n + 1) + maxCount);
    }
}