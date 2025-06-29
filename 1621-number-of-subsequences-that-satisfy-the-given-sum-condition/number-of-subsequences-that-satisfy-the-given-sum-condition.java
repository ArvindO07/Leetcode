class Solution {
    public int numSubseq(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int mod=(int) 1e9+7;
        int[] pow = new int[n];
        pow[0] = 1;
        for(int i =1; i<n; i++){
            pow[i] = (pow[i-1]*2)%mod;
        }

        int i=0;
        int j=n-1;
        int ans = 0;
        while(i<=j){
            if(nums[i]+nums[j]<=target){
                ans = ans + pow[j-i];
                ans = ans%mod;
                i++;
            }else{
                j--;
            }
        }
        return ans;
    }
}