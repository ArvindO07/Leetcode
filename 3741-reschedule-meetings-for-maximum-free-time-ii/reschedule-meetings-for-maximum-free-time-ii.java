class Solution {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int n = startTime.length;
        if (n == 0) return eventTime;

        int[] freeGap = new int[n+1];
        int[] meetingLen = new int[n];

        freeGap[0] = startTime[0];
        meetingLen[0] = endTime[0] - startTime[0];
        for (int i = 1; i < n; i++) {
            meetingLen[i] = endTime[i] - startTime[i];
            freeGap[i] = startTime[i] - endTime[i-1];
        }
        freeGap[n] = eventTime - endTime[n-1];

        int[] maxGapLeft = new int[n+1];
        int[] maxGapRight = new int[n+1];

        maxGapLeft[0] = freeGap[0];
        for (int i = 1; i <= n; i++) {
            maxGapLeft[i] = Math.max(maxGapLeft[i-1], freeGap[i]);
        }

        maxGapRight[n] = freeGap[n];
        for (int i = n - 1; i >= 0; i--) {
            maxGapRight[i] = Math.max(maxGapRight[i+1], freeGap[i]);
        }

        int best = maxGapLeft[n];

        for (int j = 0; j < n; j++) {
            int merged = freeGap[j] + meetingLen[j] + freeGap[j+1];
            int leftMax = (j > 0) ? maxGapLeft[j-1] : 0;
            int rightMax = (j + 2 <= n)  ? maxGapRight[j+2] : 0;
            int maxOther = Math.max(leftMax, rightMax);

            int candidate;
            if (maxOther >= meetingLen[j]) {
                candidate = Math.max(merged, maxOther);
            } else {
                candidate = Math.max(merged - meetingLen[j], maxOther);
            }
            best = Math.max(best, candidate);
        }

        return best;
    }
}