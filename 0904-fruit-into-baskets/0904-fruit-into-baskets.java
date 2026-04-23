class Solution {
    public int totalFruit(int[] fruits) {
        int left = 0, maxLen = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int right = 0; right < fruits.length; right++) {
            int fruitType = fruits[right];
            map.put(fruitType, map.getOrDefault(fruitType, 0) + 1);

            while (map.size() > 2) {
                int leftFruitType = fruits[left];
                map.put(leftFruitType, map.get(leftFruitType) - 1);
                if(map.get(leftFruitType) == 0) {
                    map.remove(leftFruitType);
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}