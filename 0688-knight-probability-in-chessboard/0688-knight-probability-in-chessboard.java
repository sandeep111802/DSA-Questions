class Solution {

    double prob(int k, int row, int col, int n, double[][][] dp) {

        if (row < 0 || row >= n || col < 0 || col >= n)
            return 0.0;

        if (k == 0)
            return 1.0;

        if (dp[k][row][col] != -1)
            return dp[k][row][col];

        int[] dr = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] dc = {-1, 1, -2, 2, -2, 2, -1, 1};

        double ans = 0;

        for (int i = 0; i < 8; i++) {
            ans += prob(k - 1,
                        row + dr[i],
                        col + dc[i],
                        n, dp);
        }

        return dp[k][row][col] = ans / 8.0;
    }

    public double knightProbability(int n, int k, int row, int column) {

        double[][][] dp = new double[k + 1][n][n];

        for (int i = 0; i <= k; i++) {
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < n; l++) {
                    dp[i][j][l] = -1;
                }
            }
        }

        return prob(k, row, column, n, dp);
    }
}