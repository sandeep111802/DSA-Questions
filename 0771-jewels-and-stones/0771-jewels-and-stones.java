class Solution {
    public int numJewelsInStones(String jewels, String stones) {

        HashSet<Character> set = new HashSet<>();

        for (char ch : jewels.toCharArray()) {
            set.add(ch);
        }

        int count = 0;

        for (int i = 0; i < stones.length(); i++) {
            char ch = stones.charAt(i);

            if (set.contains(ch)) {
                count++;
            }
        }

        return count;
    }
}