class Solution {
    public int concatenatedBinary(int n) {
        int MOD = 1_000_000_007;
        long result = 0;
        int length = 0;

        for (int i = 1; i <= n; i++) {
            // check power of 2
            if ((i & (i - 1)) == 0) {
                length++;
            }

            result = ((result << length) + i) % MOD;
        }
        return (int) result;
    }
}
