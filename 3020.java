class Solution {
    public int maximumLength(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                int freq = map.get(num);
                map.put(num, freq + 1);
            }
        }

        int ans = 1;

        for (int i = 0; i < n; i++) {
            int val = nums[i];
            if (val == 1) {
                int freq = map.get(val);
                if (freq % 2 == 0) {
                    ans = Math.max(freq - 1, ans);
                } else {
                    ans = Math.max(freq, ans);
                }
                continue;
            }

            if (map.get(val) > 1) {
                ans = Math.max(ans, check(map, val));
            }
        }

        return ans;
    }

    public int check(HashMap<Integer, Integer> map, int val) {
        int len = 2;
        boolean up = true;

        while (up) {
            int num = val * val;
            if (map.containsKey(num)) {
                int freq = map.get(num);
                if (freq >= 2) {
                    len += 2;
                    val = num;
                } else {
                    len++;
                    up = false;
                }
            } else {
                len--;
                up = false;
            }
        }
        return len;
    }
}
