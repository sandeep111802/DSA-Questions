class Solution {
    public int findComplement(int num) {
        
        int a = 1;

        while (a < num) {
            a = (a << 1) | 1;
        }

        return num ^ a;
    }
}