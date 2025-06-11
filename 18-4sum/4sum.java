class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int len = nums.length;

        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i< len ; i++){
            System.out.print(nums[i]+",");
        }
        System.out.println("");
        for(int i = 0; i< len; i++){
            if(i>0 && nums[i] == nums[i-1]) continue;
            for(int j = i+1; j< len ; j++){
                if(j > i+1 && nums[j] == nums[j-1]) continue;

                int k = j+1;
                int l = len-1;
                while( k < l){
                // System.out.println("nums[i]-> " + nums[i] + " | nums[j]-> " + nums[j] + " | nums[k]-> " + nums[k] + " | nums[l]-> " + nums[l]);
                    long sum = nums[j] + nums[i];
                    sum+= nums[k];
                    sum+= nums[l];
                    // System.out.println("_________________ sum-> " + sum);
                    if(sum == target){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]); 
                        temp.add(nums[j]); 
                        temp.add(nums[k]); 
                        temp.add(nums[l]);
                        ans.add(temp);
                        k++;
                        l--;
                        while(k<l && nums[k] == nums[k-1]) k++;
                        while(k<l && nums[l] == nums[l+1]) l--;

                    }else if( sum < target){
                        k++;
                    }else{
                        // System.out.println(" ----> l-> " + l);
                        l--;
                        // System.out.println(" ----> l-> " + l);
                    }
                    // System.ou/t.println("k-> " + k + " | l-> " + l);
                }
            }
        }

        return ans;


    }
}