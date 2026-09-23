class Solution {

    static final long MOD = 1000000007;

    int solve(int count_song, int count_unique, int n, int goal, int k, int[][] dp) {

        if (count_song == goal) {
            if (count_unique == n) {
                return 1;
            }
            return 0;
        }

        if (dp[count_song][count_unique] != -1) {
            return dp[count_song][count_unique];
        }

        long ans = 0;

        // Choose a new song
        if (count_unique < n) {
            ans += (long)(n - count_unique)
                    * solve(count_song + 1, count_unique + 1,
                            n, goal, k, dp);

            ans %= MOD;
        }

        // Choose an old song
        if (count_unique > k) {
            ans += (long)(count_unique - k)
                    * solve(count_song + 1, count_unique,
                            n, goal, k, dp);

            ans %= MOD;
        }

        return dp[count_song][count_unique] = (int) ans;
    }

    public int numMusicPlaylists(int n, int goal, int k) {

        int[][] dp = new int[goal + 1][n + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(0, 0, n, goal, k, dp);
    }
}