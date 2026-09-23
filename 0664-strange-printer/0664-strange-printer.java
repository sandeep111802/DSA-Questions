class Solution {
    int n;
    int[][] dp;

    int solve(int l , int r , String s){
        if(l==r){
            return 1;
        }
        if(l>r){
            return 0;
        }

        if(dp[l][r]!=-1){
            return dp[l][r];
        }

        int i = l+1;
        while(i<=r && s.charAt(i)==s.charAt(l)){
            i++;
        }

        if(i==r+1){
            return dp[l][r] = 1;
        }
        int basic = 1 + solve(i,r,s);

        int ans1 = Integer.MAX_VALUE;

        for(int j=i;j<=r;j++){
            if(s.charAt(j)==s.charAt(l)){
                int ans = solve(i,j-1,s)+solve(j,r,s);
                ans1 = Math.min(ans1,ans);
            }
        }

        return dp[l][r] = Math.min(ans1,basic);
    }
    public int strangePrinter(String s) {
        n = s.length();

       dp = new int[n+1][n+1];
       for(int [] row : dp){
         Arrays.fill(row,-1);

       }

       return solve(0,n-1,s);
    }
}