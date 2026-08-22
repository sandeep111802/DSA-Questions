class Solution {

    static int solve(int[][] matrix, int i, int j, int[][] dp) {

        int n = matrix.length;

        // Out of bounds
        if (j < 0 || j >= n) {
            return 1000000000;
        }

        // Base case
        if (i == 0) {
            return matrix[i][j];
        }

        // Already calculated
        if (dp[i][j] != Integer.MAX_VALUE) {
            return dp[i][j];
        }

        int up = solve(matrix, i - 1, j, dp);

        int left = solve(matrix, i - 1, j - 1, dp);

        int right = solve(matrix, i - 1, j + 1, dp);

        dp[i][j] = matrix[i][j] +
                Math.min(up, Math.min(left, right));

        return dp[i][j];
    }

    public int minFallingPathSum(int[][] matrix) {

        int n = matrix.length;

        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        int min = Integer.MAX_VALUE;

        // Start from every cell in last row
        for (int j = 0; j < n; j++) {
            min = Math.min(min, solve(matrix, n - 1, j, dp));
        }

        return min;
    }
}