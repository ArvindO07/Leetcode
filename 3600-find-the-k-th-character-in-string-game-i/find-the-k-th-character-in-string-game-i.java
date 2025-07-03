class Solution {
    public char kthCharacter(int k) {
        String word="a";
        while(word.length()<=k){
            StringBuilder str=new StringBuilder("");
                for(int i=0;i<word.length();i++){
                    char s=(char)((int)word.charAt(i)+1);
                    str.append(s);
                }
                word=word+str.toString();

    }
    return word.charAt(k-1);
}
}