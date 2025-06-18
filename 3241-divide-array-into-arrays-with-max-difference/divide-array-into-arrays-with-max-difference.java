class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        int len =  nums.length/3;
        
        List<Integer> temp = new ArrayList<>();
        for(int i = 0; i< nums.length; i+=3){
       
            if (i + 2 >= nums.length) return new int[0][];
            
            if (nums[i + 2] - nums[i] > k) return new int[0][];

            list.add(Arrays.asList(nums[i], nums[i + 1], nums[i + 2]));
        }


        int[][] temp2 = list.stream()
                           .map(inner -> inner.stream().mapToInt(Integer::intValue).toArray())
                           .toArray(int[][]::new);


        return temp2;
        
    }

    public void print(List<Integer> list){
        for(int i = 0; i< list.size(); i++){
            System.out.print(list.get(i) + " , ");
        }
        System.out.println("");
    }


}