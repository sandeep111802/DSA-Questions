class Solution {
    public int findClosest(int x, int y, int z) {

        int value1 = Math.abs(x - z);
        int value2 = Math.abs(y - z);

        if (value1 < value2) {
            return 1;
        } else if (value1 > value2) {
            return 2;
        } else {
            return 0;
        }
    }
}