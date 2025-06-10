class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int len = nums.length;
        int valid = len / 3;

        HashMap<Integer, Integer> mp = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if(list.contains(nums[i])) continue;
            mp.put(nums[i], mp.getOrDefault(nums[i], 0)+1);
            if (mp.get(nums[i]) > valid ) {
                list.add(nums[i]);
            }
        }
        return list;
    }
}