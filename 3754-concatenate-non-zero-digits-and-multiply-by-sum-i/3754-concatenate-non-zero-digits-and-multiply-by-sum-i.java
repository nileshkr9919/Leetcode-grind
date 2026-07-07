class Solution {
    public long sumAndMultiply(int n) {
        long x = 0, sum = 0;

        while (n > 0) {
            int digit = n % 10;
            if (digit > 0)
                x = x * 10 + digit;
            n /= 10;
            sum += digit;
        }
        long nx = 0;

        while (x > 0) {
            long digit = x % 10;
            nx = nx * 10 + digit;
            x /= 10;
        }

        return nx * sum;
    }
}