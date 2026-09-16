class Solution {

    int solve(int i, int j, String s, int[][] dp) {
         
         if(i>=j){
            return 0;
         }
         
         if(dp[i][j]!=-1){
            return dp[i][j];
         }

         if(s.charAt(i)==s.charAt(j)){
            return dp[i][j] = solve(i+1,j-1,s,dp);
         }

         return dp[i][j] = 1 + Math.min(solve(i+1,j,s,dp),solve(i,j-1,s,dp));
    }

    public int minInsertions(String s) {
        int n = s.length();

        int dp[][] = new int[n][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);

        }

        return solve(0, n - 1, s, dp);

    }
}