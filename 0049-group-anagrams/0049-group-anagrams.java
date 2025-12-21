class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();

        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            int[] arr = new int[26];

            for (char ch : str.toCharArray()) {
                arr[ch - 'a']++;
            }

            StringBuilder _key = new StringBuilder();

            for (int i = 0; i < 26; i++) {
                _key.append('#');
                _key.append(arr[i]);
            }

            String key = _key.toString();

            if (!map.containsKey(key.toString())) {
                map.put(key, new ArrayList());
            }

            map.get(key).add(str);
        }

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            res.add(entry.getValue());
        }

        return res;
    }
}