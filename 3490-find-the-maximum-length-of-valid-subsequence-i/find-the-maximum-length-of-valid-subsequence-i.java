class Solution {
    public int maximumLength(int[] nums) {
        int[] count = new int[2];
        int[] oddEven = new int[2];
        for(int num : nums) {
            int rem = num % 2;
            count[rem]++;
            oddEven[rem] = oddEven[1 - rem] + 1;
        }
        return Math.max(count[0], Math.max(count[1], Math.max(oddEven[0], oddEven[1])));
    }
}