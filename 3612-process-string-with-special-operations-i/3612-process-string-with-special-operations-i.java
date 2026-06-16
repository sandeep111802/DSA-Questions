class Solution {
    public String processStr(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            //ch is letter
            if ((ch != '*') && (ch != '#') && (ch != '%')) {
                result.append(ch);

            } else if (ch == '*') {
                if (result.length() == 0) {
                    continue;
                } else {
                    //remove last element from result
                    result.deleteCharAt(result.length() - 1);
                }
            } else if (ch == '#') {
                result.append(result);
            } else if (ch == '%') {
                StringBuilder sb = new StringBuilder();

                for (int j = result.length() - 1; j >= 0; j--) {
                    char ch2 = result.charAt(j);
                    sb.append(ch2);

                }
                result.setLength(0);
                result.append(sb);

            }
        }
        return result.toString();
    }
}