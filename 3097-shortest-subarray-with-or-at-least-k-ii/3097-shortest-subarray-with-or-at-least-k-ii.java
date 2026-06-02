class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int[] bitCount = new int[32];

        int left = 0;
        int ans = Integer.MAX_VALUE;
        int currentOR = 0;

        for (int right = 0; right < n; right++) {

            for (int b = 0; b < 32; b++) {
                if ((nums[right] & (1 << b)) != 0) {
                    bitCount[b]++;
                }
            }

            currentOR = getOR(bitCount);

            while (left <= right && currentOR >= k) {
                ans = Math.min(ans, right - left + 1);

                for (int b = 0; b < 32; b++) {
                    if ((nums[left] & (1 << b)) != 0) {
                        bitCount[b]--;
                    }
                }

                left++;
                currentOR = getOR(bitCount);
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int getOR(int[] bitCount) {
        int or = 0;

        for (int b = 0; b < 32; b++) {
            if (bitCount[b] > 0) {
                or |= (1 << b);
            }
        }

        return or;
    }
}