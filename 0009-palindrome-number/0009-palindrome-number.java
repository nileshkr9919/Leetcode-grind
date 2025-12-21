class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int rev = 0, copy = x;

        while (copy > 0) {
            rev = (rev * 10) + (copy % 10);
            copy /= 10;
        }

        return rev == x;
    }
}