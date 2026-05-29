class Solution {
    public int[] singleNumber(int[] nums) {

        int n = nums.length;
        int b1 = 0;
        int b2 = 0;

        int sing = 0;

        for (int i = 0; i < n; i++) {
            sing ^= nums[i];
        }
        int mask = (sing & (sing - 1)) ^ sing;

        for (int i = 0; i < n; i++) {

            if ((mask & nums[i]) == 0) {
                b2 ^= nums[i];
            } else {
                b1 ^= nums[i];
            }
        }

        return new int[] { b1, b2 };

    }
}