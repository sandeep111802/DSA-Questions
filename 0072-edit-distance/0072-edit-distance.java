class Solution {

    int m ,n;
     int solve(String s1 , String s2 , int i, int j, int dp[][]){
      
      if(i==m){
        return n-j;
      }else if (j==n) {
        return m-i;
      }
      
      if(dp[i][j]!=-1){
        return dp[i][j];
      }

      if(s1.charAt(i)==s2.charAt(j)){
        return dp[i][j] = solve(s1,s2,i+1,j+1,dp);
      }else{
        int insertC = 1 + solve(s1,s2,i,j+1,dp);
        int deleteC = 1 + solve(s1,s2,i+1,j,dp);
        int replaceC = 1+ solve(s1,s2,i+1,j+1,dp);

        return dp[i][j] = Math.min(insertC,Math.min(deleteC,replaceC));
      }

     
    }

    public int minDistance(String s1, String s2) {
         m = s1.length();
         n = s2.length();

        int dp[][] = new int[m][n];

        for(int [] row : dp){
            Arrays.fill(row,-1);
        }

        return solve(s1,s2,0,0,dp);
    }
}