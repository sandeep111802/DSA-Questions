class Solution {
    public int[] numMovesStonesII(int[] stones) {

        Arrays.sort(stones);

        int n = stones.length;

        // Maximum moves
        int max1 = stones[n - 1] - stones[1] + 1 - (n - 1);
        int max2 = stones[n - 2] - stones[0] + 1 - (n - 1);

        int max = Math.max(max1, max2);

        // Minimum moves
        int min = n;

        int left = 0;

        for (int right = 0; right < n; right++) {

            while (stones[right] - stones[left] + 1 > n) {
                left++;
            }

            int windowSize = right - left + 1;

            // Special case
            if (windowSize == n - 1 &&
                stones[right] - stones[left] + 1 == n - 1) {

                min = Math.min(min, 2);

            } else {

                min = Math.min(min, n - windowSize);
            }
        }

        return new int[]{min, max};
    }
}