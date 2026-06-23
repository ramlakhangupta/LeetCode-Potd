class Solution {

    static final int MOD = 1_000_000_007;

    public int zigZagArrays(int n, int l, int r) {

        int m = r - l + 1;

        long[] up = new long[m];
        long[] down = new long[m];


        for (int i = 0; i < m; i++) {
            up[i] = i;              
            down[i] = m - 1 - i;     
        }

        for (int len = 3; len <= n; len++) {

            long[] prefixUp = new long[m];
            long[] prefixDown = new long[m];

            prefixUp[0] = up[0];
            prefixDown[0] = down[0];

            for (int i = 1; i < m; i++) {
                prefixUp[i] = (prefixUp[i - 1] + up[i]) % MOD;
                prefixDown[i] = (prefixDown[i - 1] + down[i]) % MOD;
            }

            long totalUp = prefixUp[m - 1];

            long[] newUp = new long[m];
            long[] newDown = new long[m];

            for (int i = 0; i < m; i++) {
                newUp[i] = (i == 0) ? 0 : prefixDown[i - 1];

                newDown[i] = (totalUp - prefixUp[i] + MOD) % MOD;
            }

            up = newUp;
            down = newDown;
        }

        long ans = 0;

        for (int i = 0; i < m; i++) {
            ans = (ans + up[i] + down[i]) % MOD;
        }

        return (int) ans;
    }
}
