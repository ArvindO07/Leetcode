class FindSumPairs {

    private int[] nums1;
    private int[] nums2;

    HashMap<Integer,Integer> mp;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;

        mp = new HashMap<>();
        for(int i =0;i< nums2.length; i++){
            mp.put(nums2[i], mp.getOrDefault(nums2[i],0) + 1);
        }

        
    }
    
    public void add(int index, int val) {

        int count = mp.get(nums2[index]);

        if(count == 1){
            mp.remove(nums2[index]);
        }else {
            mp.put(nums2[index] , mp.get(nums2[index]) - 1);
        }

        nums2[index] = nums2[index] + val;
        mp.put(nums2[index],mp.getOrDefault(nums2[index],0) + 1);

    }
    
    public int count(int tot) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int count = 0;

        // HashMap<Integer,Integer> mp = new HashMap<>();

        // for(int i = 0; i < len1; i++){

        //     mp.put(nums1[i], mp.getOrDefault(nums1[i],0) + 1);        
        // }

        // for(int i = 0;i < len2; i++){
        //     if(mp.containsKey(tot - nums2[i] )){
        //         // System.out.println("tot-> " + tot + " | nums2[i]-> " + nums2[i]  + " | mp.get -> " + mp.get(tot-nums2[i]) );
        //         count+= mp.get(tot-nums2[i]);
        //     }
        // }
        // System.out.println(" ------------------------- ");

        for(int ele:nums1){
            count += mp.getOrDefault(tot-ele,0);
        }

        return count;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */