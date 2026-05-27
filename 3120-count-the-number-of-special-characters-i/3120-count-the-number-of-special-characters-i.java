class Solution {
    public int numberOfSpecialChars(String word) {
        int n = word.length();
        int ans =0;

        HashSet<Character> upper = new HashSet<>();
        HashSet<Character> lower = new HashSet<>();

        for(char ch :word.toCharArray()){
            if(Character.isLowerCase(ch)){
                lower.add(ch);
            }else{
                upper.add(ch);
            }
        }

        for(char ch : lower){
            if(upper.contains(Character.toUpperCase(ch))){
                ans++;
            }
        }

        return ans;

    }
}