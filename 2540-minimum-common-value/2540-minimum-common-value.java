class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int i = 0;
        int j = 0;

        while (i < m && j < n) {
            int x = nums1[i], y = nums2[j];
            if (x == y)
                return x;
            else if (x > y)
                j++;
            else
                i++;
        }

        return -1;

    }
}