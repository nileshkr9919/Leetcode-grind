class Solution {
    public int sumFourDivisors(int[] nums) {
        int res = 0;
        for (int n : nums) {
            int count = 2, sum = n + 1;
            for (int i = 2; (i * i) <= n; i++) {
                if (n % i == 0) {
                    int j = n / i;

                    if (i == j) {
                        count++;
                        sum += i;
                    } else {
                        count += 2;
                        sum += i + j;
                    }

                    if (count > 4)
                        break;
                }
            }
            if (count == 4) {
                res += sum;
            }
        }

        return res;
    }
}