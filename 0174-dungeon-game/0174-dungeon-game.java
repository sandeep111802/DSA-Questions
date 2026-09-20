class Solution {
    int [][] dp;
    int m,n;
    int solve(int i,int j,int [][] dungeon){
        if(i>=m || j>=n){
            return Integer.MAX_VALUE;
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        if(i==m-1 && j==n-1){
            if(dungeon[i][j]>0){
                return 1;
            }
            return Math.abs(dungeon[i][j])+1;
        }

        int right = solve(i,j+1,dungeon);
        int down = solve(i+1,j,dungeon);

        int result = Math.min(right,down) - dungeon[i][j];

        return dp[i][j] = (result>0) ? result : 1;
    }
    public int calculateMinimumHP(int[][] dungeon) {
        m= dungeon.length;
        n = dungeon[0].length;

        dp = new int[m][n];

        for(int [] row : dp){
            Arrays.fill(row,-1);
        }

        return solve(0,0,dungeon);
    }
}