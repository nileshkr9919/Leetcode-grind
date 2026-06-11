class Solution {
    public boolean detectCapitalUse(String word) {
        boolean first = false, allUpper = true, allLower = true;
        first = Character.isUpperCase(word.charAt(0));
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (Character.isLowerCase(ch))
                allUpper = false;
            else if (Character.isUpperCase(ch)) {
                allLower = false;
                if (i != 0)
                    first = false;
            }
        }

        return first || allUpper || allLower;
    }
}