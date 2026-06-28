class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int maxElement = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            if(i == 0) {
                arr[0] = 1;
            } else if(Math.abs(arr[i] - arr[i-1]) > 1) {
                arr[i] = arr[i-1] + 1;
            }
            maxElement = Math.max(maxElement, arr[i]);
        }
        return maxElement;
    }
}
