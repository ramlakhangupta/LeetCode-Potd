class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int[] prefixGcd = new int[n];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            int val = gcd(nums[i], max);
            prefixGcd[i] = val;
        }

        Arrays.sort(prefixGcd);

        int i = 0;
        int j = n - 1;

        long ans = 0;
        while (i != j && i < j) {
            int val = gcd(prefixGcd[i], prefixGcd[j]);
            ans += val;
            i++;
            j--;
        }

        return ans;
    }

    // GCD Finding
    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
