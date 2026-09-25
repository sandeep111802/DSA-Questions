class Solution {
    Boolean[] dp ;
    int n;

    boolean solve(int idx , String s, List<String> wordDict){
        if(idx == n){
            return true;
        }
        if(dp[idx]!=null){
            return dp[idx];
        }

        for(int l = idx+1;l<=n;l++){
            String split = s.substring(idx,l);

            if(wordDict.contains(split) && solve(l,s,wordDict)){
                return true;
            }
        }

        return dp[idx] = false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        n= s.length();
        dp = new Boolean[n];

        return solve(0,s,wordDict);
    }
}