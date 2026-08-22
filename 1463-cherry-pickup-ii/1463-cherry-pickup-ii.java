class Solution {

    static int solve(int[][] grid, int i, int j1, int j2, int[][][] dp) {
        int n = grid.length;
        int m = grid[0].length;

        if (j1 < 0 || j1 >= m || j2 < 0 || j2 >= m) {
            return Integer.MIN_VALUE;
        }
        if (i == n - 1) {
            if (j1 == j2) {
                return grid[i][j1];
            }
            return grid[i][j1] + grid[i][j2];
        }

        if (dp[i][j1][j2] != -1) {
            return dp[i][j1][j2];
        }

        int max = Integer.MIN_VALUE;

        for (int d1 = -1; d1 <= 1; d1++) {
            for (int d2 = -1; d2 <= 1; d2++) {
                int cherries;

                if (j1 == j2) {
                    cherries = grid[i][j1];
                } else {
                    cherries = grid[i][j1] + grid[i][j2];
                }

                cherries += solve(grid, i + 1, j1 + d1, j2 + d2, dp);

                max = Math.max(max, cherries);
            }

        }

        dp[i][j1][j2] = max;
        return max;
    }

    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][][] dp = new int[n][m][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return solve(grid, 0, 0, m - 1, dp);
    }
}