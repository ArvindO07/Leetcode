class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int st = 0;
        ArrayList<Integer> gaps = new ArrayList<>();
        int n = startTime.length;
        for (int i = 0; i < n; i++) {
            gaps.add(startTime[i] - st);
            st = endTime[i];
        }
        gaps.add(eventTime - st);
        gaps.add(0);
        int[] g = new int[gaps.size()];
        for (int i = 0; i < gaps.size(); i++) {
            g[i] = gaps.get(i);
        }
        int len = g.length;
        int max = 0;
        int i = 0;
        int curr = 0;
        for (int j = 0; j < len;) {
            while (j<len && j - i < k + 1) {
                curr += g[j];
                j++;
            }
            max = Math.max(curr, max);
            curr -= g[i];
            i++;
        }
        return max;
    }
}