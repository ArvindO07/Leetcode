class Solution {

    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = baskets.length;
        int s= (int) Math.sqrt(n);
        int section = (n + s - 1) / s;
        int count = 0;
        int[] maxP = new int[section];
        Arrays.fill(maxP, 0);

        for (int i = 0; i < n; i++) {
            maxP[i / s] = Math.max(maxP[i / s], baskets[i]);
        }

        for (int fruit : fruits) {
            int sec;
            int unset = 1;
            for (sec = 0; sec < section; sec++) {
                if (maxP[sec] < fruit) {
                    continue;
                }
                int choose = 0;
                maxP[sec] = 0;
                for (int i = 0; i < s; i++) {
                    int pos = sec * s + i;
                    if (pos < n && baskets[pos] >= fruit && choose == 0) {
                        baskets[pos] = 0;
                        choose = 1;
                    }
                    if (pos < n) {
                        maxP[sec] = Math.max(maxP[sec], baskets[pos]);
                    }
                }
                unset = 0;
                break;
            }
            count += unset;
        }
        return count;
    }
}