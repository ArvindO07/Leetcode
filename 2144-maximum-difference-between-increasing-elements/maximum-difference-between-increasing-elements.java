class Solution {
    public int maximumDifference(int[] nums) {
        int min = nums[0];
        int ans = -1;
        for(int i = 1; i<nums.length;i++){
            int curr = nums[i] - min;
            ans = Math.max(ans,curr);
            min = Math.min(min,nums[i]);
        }
        if(ans<= 0 )  return -1;
        return ans;
    }
}