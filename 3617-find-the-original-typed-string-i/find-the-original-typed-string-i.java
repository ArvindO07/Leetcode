class Solution {
    public int possibleStringCount(String word) {
        int i=0;
        int j=0;
        int length=0;
        int possibleStringCount=0;
        
        while(j<word.length()){
            if(word.charAt(i)==word.charAt(j)){
                j++;
            }
            else{
                length=j-i;
                if(length!=1)possibleStringCount+=length-1;
                i=j;            
            }
        }
        length=j-i;
        if(length!=1)possibleStringCount+=length-1; 
        return possibleStringCount+1; //+1 for unique character string
    }
}