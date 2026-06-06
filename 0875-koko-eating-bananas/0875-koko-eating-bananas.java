class Solution {

    boolean ifCanEatAll(int[] piles, int k, int h) {
        long hours = 0;

        for (int x : piles) {
            hours += (x / k);

            if (x % k != 0) {
                hours++;
            }
        }

        return hours <= h;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        // int r = Arrays.stream(piles).max().getAsInt();
        int r = piles[0];

        for (int pile : piles) {
            r = Math.max(r, pile);
        }

        int ans = r;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (ifCanEatAll(piles, mid, h)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }
}