class Solution {
    public int maxNumberOfBalloons(String text) {
        int n = text.length();
        int[] arr = new int[26];
        for (int i = 0; i < n; i++) {
            int index = text.charAt(i) - 'a';
            arr[index] = arr[index] + 1;
        }

        String check = "balloon";
        int count = 0;
        int i = 0;
        while (i >= 0) {
            if (i == 7) {
                count++;
                i = 0;
                continue;
            }
            int index = check.charAt(i) - 'a';

            if (arr[index] == 0) {
                return count;
            }
            arr[index] = arr[index] - 1;
            i++;
        }

        return count;
    }
}
