class Solution {

    static int helper(int n , int [] dp){
       
        if(n==1|| n==2){  // base case
            return n;

        }
        if(dp[n]!=0){      // store value
           return dp[n];
        }


       dp[n]= helper(n-1,dp) + helper(n-2,dp);  // recursive 
       return dp[n];

    }
    public int climbStairs(int n) {

     int [] dp = new int[n+1];           // define for storage 

     return helper(n,dp);

       
    }
}