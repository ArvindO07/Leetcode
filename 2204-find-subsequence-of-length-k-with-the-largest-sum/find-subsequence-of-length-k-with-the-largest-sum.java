class Solution {
    class Pair <K, V> {
        K first;
        V second;
        Pair(K first, V second) {
            this.first = first;
            this.second = second;
        }
    }
    public int[] maxSubsequence(int[] nums, int k) {
        Queue<Pair<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> a.first - b.first);
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            minHeap.add(new Pair(num, i));
            if (minHeap.size() > k)
                minHeap.poll();
        }

        List<Pair<Integer, Integer>> minList = new ArrayList<>(minHeap);
        Collections.sort(minList, (a, b) -> a.second - b.second);

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = minList.get(i).first;
        }

        return res;
    }
}