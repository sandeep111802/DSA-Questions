class Solution {
    public int[] limitOccurrences(int[] nums, int k) {
        HashMap<Integer,Integer> mp = new HashMap<>();

        for(int x:nums){
            mp.put(x,mp.getOrDefault(x,0)+1);
        }

        ArrayList<Integer> list = new ArrayList<>();

        for(int num : nums){
            if(mp.containsKey(num)){
                int freq = mp.get(num);

                if(freq<=k){
                     while(mp.get(num)>0){
                        list.add(num);
                        mp.put(num,mp.get(num)-1);
                     }
                     if(mp.get(num)==0){
                        mp.remove(num);
                     }
                }else{
                     for(int i=1;i<=k;i++){
                        list.add(num);
                     }
                     mp.remove(num);
                }
            }
        }

        int [] arr = new int[list.size()];
         int i=0;

         for(int num : list){
            arr[i++]=num;
         }

         return arr;
    }
}