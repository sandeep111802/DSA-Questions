class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
          int[][] mat = new int[n][n];

        for (int[] i : queries) {

            int r1 = i[0];
            int c1 = i[1];
            int r2 = i[2];
            int c2 = i[3];

            for (int row = r1; row <= r2; row++) {
                mat[row][c1]++;

                if (c2+1 < n) {
                    mat[row][c2+1]--;
                }
            }
        }

        for (int row = 0; row < n; row++) {
            for (int col = 1; col < n; col++) {
                mat[row][col] += mat[row][col - 1];
            }
        }

        return mat;
    }
}