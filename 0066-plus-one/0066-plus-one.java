class Solution {
    public int[] plusOne(int[] digits) {
        int index = digits.length - 1;

        while (index >= 0) {
            digits[index]++;

            if (digits[index] > 9) {
                digits[index] = 0;
            } else {
                return digits;
            }
            index--;
        }

        int[] res = new int[(digits.length + 1)];
        res[0] = 1;

        for (int i = 1; i < res.length; i++) {
            res[i] = 0;
        }

        return res;
    }
}