class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;
        for (int i = 0; i < n; i++) {
            int j = 0, k = n - 1;
            while (j <= k) {
                int temp = image[i][j] ^ 1;
                image[i][j] = image[i][k] ^ 1;
                image[i][k] = temp;
                j++;
                k--;
            }
        }
        return image;
    }
}