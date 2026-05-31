class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {

        int[] prefix = new int[arr.length];
        int[] ans = new int[queries.length];

        prefix[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i - 1] ^ arr[i];
        }

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            if (l > 0) {
                ans[i] = prefix[r] ^ prefix[l - 1];

            } else {
                ans[i] = prefix[r];
            }
        }

        return ans;
    }
}