class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();

        int maxFreq = 0, maxCount = 0;

        for (char ch : tasks) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            if (maxFreq == map.get(ch)) {
                maxCount++;
            } else if(map.get(ch) > maxFreq) {
                maxCount = 1;
            }
            maxFreq = Math.max(maxFreq, map.get(ch));
        }

        return Math.max(tasks.length, (maxFreq - 1) * (n + 1) + maxCount);
    }
}