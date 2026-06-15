class Solution {
    public int[] arrayRankTransform(int[] arr) {
        
        int[] A = Arrays.copyOf(arr, arr.length);
        Arrays.sort(A);

        HashMap<Integer, Integer> rankMap = new HashMap<>();
        int rank =1;
        for (int x : A){
            if(!rankMap.containsKey(x)){
                rankMap.put(x,rank);
                rank++;
            }
        }

        for (int i = 0; i < arr.length; ++i){
            A[i] = rankMap.get(arr[i]);
        }
          
        return A;
    }
}