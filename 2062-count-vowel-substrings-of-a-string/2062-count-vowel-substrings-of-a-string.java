class Solution {
    public int countVowelSubstrings(String word) {
        int n = word.length();

        int count = 0;

        for (int i = 0; i < n; i++) {
            HashSet<Character> set = new HashSet<>();

            for (int j = i; j < n; j++) {
                char c = word.charAt(j);

                if (!isVowel(c)) {
                    break;
                }

                set.add(c);
                if (set.size() == 5) {
                    count++;
                }
            }
        }

        return count;

    }

    static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}