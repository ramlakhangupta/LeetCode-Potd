class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int n = patterns.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            String pattern = patterns[i];
            if (check(pattern, word)) {
                count++;
            }
        }

        return count;
    }

    public boolean check(String pattern, String word) {

        int n = word.length();
        int m = pattern.length();

        for (int i = 0; i <= n - m; i++) {

            int j = 0;

            while (j < m && word.charAt(i + j) == pattern.charAt(j)) {
                j++;
            }

            if (j == m)
                return true;
        }

        return false;
    }
}

/////////////////////////////            DIRECT METHOD      /////////////////////////////////////
class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int n = patterns.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            String pattern = patterns[i];
            if (word.contains(pattern)) {
                count++;
            }
        }

        return count;
    }

    
}
