class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        
         int n = seq.length();
        int [] result = new int[n];
       

        int d =0;

        for(int i=0;i<n;i++){
           if(seq.charAt(i)=='('){
              result[i] = (d%2==0)?0:1;
              d++;
           }else{
              result[i] = (d%2==0)?1:0;
              d--;
           }
        }

        return result;

    }
}