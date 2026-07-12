class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] copy = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            copy[i] = arr[i];
        }

        Arrays.sort(copy);

        // System.out.println(Arrays.toString(copy));

        HashMap<Integer, Integer> map = new HashMap<>();
        int rank = 1;

        for (int i = 0; i < copy.length; i++) {
            if (!map.containsKey(copy[i])) {
                map.put(copy[i], rank++);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }

        return arr;
    }
}