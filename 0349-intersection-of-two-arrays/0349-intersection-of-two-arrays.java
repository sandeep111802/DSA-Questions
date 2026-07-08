class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> h1 = new HashSet<>();
        HashSet<Integer> h2 = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        for (int x : nums1) {
            h1.add(x);
        }

        for (int x : nums2) {
            h2.add(x);
        }

        for (int x : h1) {
            if (h2.contains(x)) {
                list.add(x);
            }
        }

        int[] arr = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }

        return arr;

    }
}