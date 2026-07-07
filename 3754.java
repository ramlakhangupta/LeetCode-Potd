class Solution {
    public long sumAndMultiply(int n) {
        String str = String.valueOf(n);
        long x = 0;
        long sum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '0') {
                Long val = Long.parseLong(str.charAt(i) + "");
                x *= 10;
                x += val;
                sum += val;
            }
        }

        return x * sum;
    }
}
