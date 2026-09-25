class Solution {
    int[][] dp;
    int n;

    int solve(int i, int p, int[] nums) {

        if (i >= n) {
            return 0;
        }

        if (dp[i][p + 1] != -1) {
            return dp[i][p + 1];
        }

        int take = 0;

        if (p == -1 || nums[i] > nums[p]) {
            take = 1 + solve(i + 1, i, nums);
        }

        int skip = solve(i + 1, p, nums);

        return dp[i][p + 1] = Math.max(take, skip);
    }

    public int lengthOfLIS(int[] nums) {

        n = nums.length;

        dp = new int[n][n + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(0, -1, nums);
    }
}