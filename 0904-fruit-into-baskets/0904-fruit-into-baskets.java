class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;
        int left = 0;

        for (int i = 0; i < fruits.length; i++) {
            int type = fruits[i];
            map.put(type, map.getOrDefault(type, 0) + 1);

            while (map.size() > 2) {
                int leftMostFruit = fruits[left];
                map.put(leftMostFruit, map.get(leftMostFruit) - 1);
                if (map.get(leftMostFruit) <= 0) {
                    map.remove(leftMostFruit);
                }
                left++;
            }

            maxLen = Math.max(maxLen, i - left + 1);
        }

        return maxLen;
    }
}