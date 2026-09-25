class Solution {
    double [][] dp ;
    

    int [][] serves = {
        {100,0},{75,25},{50,50},{25,75}
    };


    double solve(int A,int B){
       
        if(A<=0 && B<=0){
            return 0.5;
        }
         if(A<=0){
            return 1.0;
        }
        if(B<=0){
            return 0.0;
        }

        if(dp[A][B]!=-1.0){
            return dp[A][B];
        }

        double prob = 0.0;

        for(int [] serve : serves){
            int Aserve = serve[0];
            int Bserve = serve[1];

            prob += 0.25 * solve(A-Aserve , B-Bserve);
        }

        return dp[A][B]= prob;
    }
    public double soupServings(int n) {
        if(n>=5000){
            return 1;
        }

        dp = new double [n+1][n+1];
        for(double [] row : dp){
            Arrays.fill(row,-1.0);
        }

        return solve(n,n);
    }
}