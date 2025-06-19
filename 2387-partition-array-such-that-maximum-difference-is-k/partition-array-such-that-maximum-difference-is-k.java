class Solution {
    public int partitionArray(int[] nums, int k) {
        int len = nums.length;
        Arrays.sort(nums);
        int count = 0;
        int i = 0;

         while (i < len) {
            int groupStart = nums[i]; 
            // System.out.print(" groupstart-> "+groupStart);
            while (i < len && nums[i] - groupStart <= k) {
                // System.out.print(" | nums["+i+"]-> " + nums[i]);
                i++;
            }
            // System.out.println("");
            count++;  
        }
        // System.out.println("");


        return count;
    }
}