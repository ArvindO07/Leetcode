class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int count = 1;
        int ans = 1;
        int len = nums.length;
        if(len == 0) return 0;

        for(int i = 1; i<nums.length; i++){
            int first = nums[i-1];
            int second = nums[i] ;
            if(first == second) continue;

            if(first+1 == second){
                count++;
            }else{
                count = 1;
            }
            if(count > ans){
                ans = count;
            }
        }
        return ans;
    }
}