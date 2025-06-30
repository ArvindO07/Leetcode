class Solution {
    public int findLHS(int[] nums) {
        var map = new HashMap<Integer, Integer>();
        for (var num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int ans = 0;
        for (var key : map.keySet()) {
            if (map.containsKey(key + 1)) {
                ans = Math.max(ans, map.get(key) + map.get(key + 1));
            }
        }
        return ans;
    }
}