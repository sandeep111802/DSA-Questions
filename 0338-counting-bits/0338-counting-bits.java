class Solution {

    private int hammingWeight(int n) {
        int count = 0;

        while (n > 0) {
            n = (n & (n - 1));
            count++;
        }

        return count;
    }

    public int[] countBits(int n) {

        int[] result = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            result[i] = hammingWeight(i);
        }

        return result;
    }
}