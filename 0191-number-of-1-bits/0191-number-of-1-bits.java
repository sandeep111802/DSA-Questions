class Solution {
    public int hammingWeight(int n) {
        int count =0;

        //  while(n>0){
        //     count+=(n%2);
        //     n/=2;
        //  }

        while(n>0){
            n=(n&(n-1));
            count++;
        }

        return count;
    }
}