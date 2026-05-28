class Solution {
    public int totalHammingDistance(int[] nums) {
        int ans =0;

        for(int k=0;k<32;k++){
            int ones =0;
            int zeroes =0;

            for(int num : nums){
                if((num &(1<<k))!=0){
                    ones++;
                }else{
                    zeroes++;
                }
            }
            ans += ones*zeroes;
        }

        return ans;
    }
}