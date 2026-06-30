class Solution {
    public int numberOfSubstrings(String s) {

        int lastA = -1;
        int lastB = -1;
        int lastC = -1;

        int count = 0;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == 'a')
                lastA = i;
            else if (ch == 'b')
                lastB = i;
            else
                lastC = i;

            if (lastA != -1 && lastB != -1 && lastC != -1) {
                count += Math.min(lastA, Math.min(lastB, lastC)) + 1;
            }
        }

        return count;
    }
}
