class Solution {
    public int numberOfSpecialChars(String word) {
        int n = word.length();
        int count = 0;

        int[] lastSmall = new int[26];
        int[] firstCapital = new int[26];

        Arrays.fill(lastSmall, -1);
        Arrays.fill(firstCapital, -1);

        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i);

            if (Character.isLowerCase(ch)) {
                lastSmall[ch - 'a'] = i;
            } else {
                if (firstCapital[ch - 'A'] == -1) {
                    firstCapital[ch - 'A'] = i;
                }
            }
        }

        for (int i = 0; i < 26; i++) {
            if (lastSmall[i] != -1 && firstCapital[i] != -1 && lastSmall[i] < firstCapital[i]) {
                count++;
            }
        }

        return count;
    }
}