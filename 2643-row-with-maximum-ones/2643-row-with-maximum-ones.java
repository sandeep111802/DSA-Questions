class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int count = 0;
        int max = Integer.MIN_VALUE;
        int index = 0;

        for (int i = 0; i < mat.length; i++) {
            count = 0;
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    count = count + 1;

                }
            }
            if (count > max) {
                max = count;
                index = i;

            }

        }

        return new int[] { index, max };
    }
}