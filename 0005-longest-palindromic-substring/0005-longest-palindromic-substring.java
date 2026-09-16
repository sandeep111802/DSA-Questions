import java.util.*;

class Solution {

    Boolean[][] dp;

    boolean solve(int i, int j, String s) {

        if (i >= j) {
            return true;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        if (s.charAt(i) == s.charAt(j)) {
            return dp[i][j] = solve(i + 1, j - 1, s);
        }

        return dp[i][j] = false;
    }

    public String longestPalindrome(String s) {

        int n = s.length();

        int maxLen = Integer.MIN_VALUE;
        int sp = 0;

        dp = new Boolean[n][n];

        for (int i = 0; i < n; i++) {

            for (int j = i; j < n; j++) {

                if (solve(i, j, s)) {

                    int currentLen = j - i + 1;

                    if (currentLen > maxLen) {

                        maxLen = currentLen;
                        sp = i;
                    }
                }
            }
        }

        return s.substring(sp, sp+maxLen);
    }
}