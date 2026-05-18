class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long count = 0;
        long res = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 0) {
                count++;
                res += count;
            } else {
                count = 0;
                continue;
            }
        }

        return res;
    }
}