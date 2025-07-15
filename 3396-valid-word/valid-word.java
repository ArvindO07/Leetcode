class Solution {
    public boolean isValid(String word) {
        if(word.length() < 3){
            return false;
        }
        String s1 = "aeiouAEIOU";
        String s2 = "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ";
        int vowelCount = 0;
        int consonantCount = 0;
        for(char ch : word.toCharArray()){
            if(!Character.isDigit(ch)){
                if(s1.contains(String.valueOf(ch))){
                    vowelCount++;
                }else if(s2.contains(String.valueOf(ch))){
                    consonantCount++;
                }else{
                    return false;
                }
            }
        }
        if(vowelCount < 1 || consonantCount < 1){
            return false;
        }
        return true;
    }
}