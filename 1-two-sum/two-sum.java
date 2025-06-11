class Solution {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;

        int[] ans = new int[2];

        HashMap<Integer,Integer> mp = new HashMap<>();

        for(int i = 0; i< len ;i++){
            int find = target-nums[i] ;
            if(mp.containsKey(find)){
                ans[0] = mp.get(find);
                ans[1] = i;
                return ans;
            }else{
                mp.put(nums[i],i);
            }
        }

        return ans;
    }
}