class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);

        int ans = 0;

        for (int x : arr1) {
            int idx = lowerBound(arr2, x - d);

            if (idx == arr2.length || arr2[idx] > x + d) {
                ans++;
            }
        }

        return ans;
    }

    private int lowerBound(int[] arr, int target) {
        int l = 0, r = arr.length;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (arr[mid] < target)
                l = mid + 1;
            else
                r = mid;
        }

        return l;
    }
}