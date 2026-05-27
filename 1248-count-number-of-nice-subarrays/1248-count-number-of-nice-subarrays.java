class Solution {
    public int numberOfSubarrays(int[] nums, int k) {

        HashMap<Integer,Integer> map = new HashMap<>();

        int oddCount =0;
        int result =0;

        map.put(0,1);

        for(int i=0;i<nums.length;i++){
            oddCount+=(nums[i]%2);

            if(map.containsKey(oddCount-k)){
                result+=(map.get(oddCount-k));
            }
             map.put(oddCount, map.getOrDefault(oddCount, 0) + 1);
        }

        return result;
    }
}