class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {

        Arrays.sort(items, (a, b) -> a[0] - b[0]);

        int n = items.length;

        int[] prices = new int[n];
        int[] maxBeauty = new int[n];

        int best = 0;

        for (int i = 0; i < n; i++) {
            prices[i] = items[i][0];

            best = Math.max(best, items[i][1]);

            maxBeauty[i] = best;
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int q = queries[i];

            int l = 0;
            int r = n - 1;

            while (l <= r) {
                int mid = l + (r - l) / 2;

                if (prices[mid] <= q)
                    l = mid + 1;
                else
                    r = mid - 1;
            }

            ans[i] = (r >= 0) ? maxBeauty[r] : 0;
        }

        return ans;
    }
}