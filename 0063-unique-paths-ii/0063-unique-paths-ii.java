class Solution {

    static int solve(int obstacleGrid[][],int i,int j,int dp[][]){
        if(i==0 && j==0){
            if(obstacleGrid[i][j]==1){
                return 0;
            }
            return 1;
        }

        if(i<0|| j<0){
            return 0;
        }
        if(obstacleGrid[i][j]==1){
            return 0;
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int up = solve(obstacleGrid,i-1,j,dp);
        int left = solve(obstacleGrid,i,j-1,dp);

        dp[i][j]= up+left;

        return dp[i][j];
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int [][] dp = new int[m][n];

        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }

        return solve(obstacleGrid,m-1,n-1,dp);
    }
}