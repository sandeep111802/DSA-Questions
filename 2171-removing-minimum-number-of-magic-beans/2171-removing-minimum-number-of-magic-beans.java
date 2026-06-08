class Solution {
    public long minimumRemoval(int[] beans) {

        Arrays.sort(beans);

        int n = beans.length;
        long total = 0;

        for (int x : beans) {
            total += x;
        }

        long ans = Long.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            long kept = (long) beans[i] * (n - i);
            ans = Math.min(ans, total - kept);
        }

        return ans;

    }
}