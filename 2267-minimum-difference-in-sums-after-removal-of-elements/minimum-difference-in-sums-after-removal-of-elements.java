class Solution {
    public long minimumDifference(int[] nums) {
        int N = nums.length;
        int n = N / 3;

        long[] left = new long[N];
        long[] right = new long[N];

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        long leftSum = 0;
        for(int i = 0; i < 2 * n; i++){
            maxHeap.offer(nums[i]);
            leftSum += nums[i];

            if(maxHeap.size() > n){
                leftSum -= maxHeap.poll();
            }
            left[i] = leftSum;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long rigthSum = 0;
        for(int i = N - 1; i >= n; i--){
            minHeap.offer(nums[i]);
            rigthSum += nums[i];

            if(minHeap.size() > n){
                rigthSum -= minHeap.poll();
            }
            right[i] = rigthSum;
        }

        long result = Long.MAX_VALUE;
        for(int i = n - 1; i < 2 * n; i++){
            result = Math.min(result, left[i] - right[i + 1]);
        }
        return result;
    }
}