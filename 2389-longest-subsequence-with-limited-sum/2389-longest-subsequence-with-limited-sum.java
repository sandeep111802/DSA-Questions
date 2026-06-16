class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {

        Arrays.sort(nums);

        int n = nums.length;

        int[] prefix = new int[n];

        prefix[0] = nums[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int q = queries[i];

            int l = 0;
            int r = n - 1;

            while (l <= r) {

                int mid = l + (r - l) / 2;

                if (prefix[mid] <= q)
                    l = mid + 1;
                else
                    r = mid - 1;
            }

            ans[i] = r + 1;
        }

        return ans;
    }
}