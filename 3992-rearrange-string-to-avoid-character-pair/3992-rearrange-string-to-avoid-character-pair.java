class Solution {
    public String rearrangeString(String s, char x, char y) {
         int yCnt = 0;

        for (char ch : s.toCharArray()) {
            if (ch == y) {
                yCnt++;
            }
        }

        s = s.replace(y + "", "");

        while (yCnt-- != 0) {
            s = y + s;
        }

        return s;
    }
}