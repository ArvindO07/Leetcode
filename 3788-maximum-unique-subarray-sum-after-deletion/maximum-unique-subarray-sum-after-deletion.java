class Solution {
    public int maxSum(int[] nums) {
        Arrays.sort(nums);
        int sum=nums[nums.length-1];
        for(int i=nums.length-1;i>0;i--){
            if(nums[i-1]>0&&nums[i]!=nums[i-1]) sum+=nums[i-1];
        }
        return sum;
    }
}