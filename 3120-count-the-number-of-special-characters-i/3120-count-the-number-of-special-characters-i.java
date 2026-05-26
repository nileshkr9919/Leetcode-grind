class Solution {
    public int numberOfSpecialChars(String word) {
        int[] freqL = new int[26];
        int[] freqU = new int[26];

        for (char ch : word.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                freqU[ch - 'A']++;
            } else {
                freqL[ch - 'a']++;
            }
        }

        int res = 0;

        for (int i = 0; i < 26; i++) {
            if (freqL[i] > 0 && freqU[i] > 0) {
                res++;
            }
        }

        return res;
    }
}