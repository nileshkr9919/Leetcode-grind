class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;

        int[] s1Freq = new int[26];
        int[] s2Freq = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            s1Freq[s1.charAt(i) - 'a']++;
            s2Freq[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(s1Freq, s2Freq))
            return true;

        for (int right = s1.length(); right < s2.length(); right++) {
            s2Freq[s2.charAt(right) - 'a']++; // add right
            s2Freq[s2.charAt(right - s1.length()) - 'a']--; // remove left
            if (Arrays.equals(s1Freq, s2Freq))
                return true;
        }

        return false;
    }
}