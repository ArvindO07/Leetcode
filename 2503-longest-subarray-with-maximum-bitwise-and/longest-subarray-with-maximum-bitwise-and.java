class Solution {
    public int longestSubarray(int[] nums) {
        int d = 0 ;
        for(int i = 0 ;i<nums.length;i++){
            d = Math.max(nums[i],d);
        }
        
        int c = 0;
        int x = 0;
        for(int i=0;i<nums.length;i++ ){
            if(nums[i]==d){
             c++;
              x = Math.max(c,x);
            }
            else{
               
                c=0;
            }
        }
        return x;
    }
}