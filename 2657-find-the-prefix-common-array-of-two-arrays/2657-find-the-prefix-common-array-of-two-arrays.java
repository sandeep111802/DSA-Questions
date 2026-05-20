class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {

        int n = A.length;

        int[] result = new int[n];

        HashSet<Integer> seenA = new HashSet<>();
        HashSet<Integer> seenB = new HashSet<>();

        int common = 0;

        for (int i = 0; i < n; i++) {

            seenA.add(A[i]);
            seenB.add(B[i]);

            if (seenB.contains(A[i])) {
                common++;
            }

            if (A[i] != B[i] && seenA.contains(B[i])) {
                common++;
            }

            result[i] = common;
        }

        return result;
    }
}