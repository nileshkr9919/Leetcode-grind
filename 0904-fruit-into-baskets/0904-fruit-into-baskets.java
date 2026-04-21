class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0, maxTotal = 0, total = 0;

        for (int right = 0; right < fruits.length; right++) {
            int fruitType = fruits[right];
            map.put(fruitType, map.getOrDefault(fruitType, 0) + 1);

            while (map.size() > 2) {
                int leftFruit = fruits[left];
                map.put(leftFruit, map.get(leftFruit) - 1);

                if (map.get(leftFruit) == 0) {
                    map.remove(leftFruit);
                }

                left++;
            }

            maxTotal = Math.max(maxTotal, right - left + 1);

        }

        return maxTotal;
    }
}