class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> words = new HashSet<>();

        for (String s : wordList) {
            words.add(s);
        }

        if (!words.contains(endWord)) {
            return 0;
        }
        
        HashSet<String> visited = new HashSet<>();
        Deque<String> queue = new ArrayDeque<>();
        queue.add(beginWord);
        visited.add(beginWord);
        int steps = 1;


        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int k = 0; k < size; k++) {
                String word = queue.poll();

                if (word.equals(endWord))
                    return steps;

                for (int i = 0; i < word.length(); i++) {
                    char[] chars = word.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[i] = c;
                        String next = new String(chars);
                        if (words.contains(next) && !visited.contains(next)) {
                            queue.add(next);
                            visited.add(next);
                        }
                    }
                }
            }
            steps++;
        }
        return 0;
    }
}