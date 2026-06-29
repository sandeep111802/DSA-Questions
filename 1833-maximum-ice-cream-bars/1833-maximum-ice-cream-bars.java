class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int max = costs[0];
        for(int num : costs){
            if(num > max){
                max = num;
            }
        }

        int[] count = new int[max + 1];
        for(int num : costs){
            count[num]++;
        }

        int iceCreams = 0;
        for(int i = 1; i <= max; i++){
            if(i > coins){
                break;
            }

            while(count[i] != 0 && i <= coins){
                iceCreams++;
                count[i]--;
                coins -= i;
            }
        }
        
        return iceCreams;
    }
}