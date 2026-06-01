class Solution {

    private static final long MOD = 1000000007L;

    public int maximumXorProduct(long a, long b, int n) {

        long A = 0;
        long B = 0;

        // Copy bits that cannot be changed
        for (int i = 49; i >= n; i--) {
            if (((a >> i) & 1L) == 1) {
                A |= (1L << i);
            }

            if (((b >> i) & 1L) == 1) {
                B |= (1L << i);
            }
        }

        // Build the lower n bits greedily
        for (int i = n - 1; i >= 0; i--) {

            boolean aBit = ((a >> i) & 1L) == 1;
            boolean bBit = ((b >> i) & 1L) == 1;

            if (aBit == bBit) {
                // Make both bits 1
                A |= (1L << i);
                B |= (1L << i);
            } else {
                // Give the bit to the smaller number
                if (A < B) {
                    A |= (1L << i);
                } else {
                    B |= (1L << i);
                }
            }
        }

        return (int) ((A % MOD) * (B % MOD) % MOD);
    }
}