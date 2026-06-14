class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
          int[] diff = new int[102];

        for (List<Integer> num : nums) {
            int start = num.get(0);
            int end = num.get(1);

            diff[start]++;
            if (end + 1 < diff.length) {
                diff[end + 1]--;
            }
        }

        int cars = 0;
        int count = 0;
        for (int i = 0; i < 101; i++) {
            cars += diff[i];
            
            if (cars > 0) count++;
        }

        return count;
    }
}