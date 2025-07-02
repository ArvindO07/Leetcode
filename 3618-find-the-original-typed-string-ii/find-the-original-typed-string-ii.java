class Solution {
    public int possibleStringCount(String Word, int k) {
        char[] word = Word.toCharArray();
        int n = word.length;
        int[] cnts = new int[n];
        int cn = 1;
        char pc = 0;
        for (char c : word) {
            if (c != pc) {
                --k;
                if (cnts[cn - 1] > 0) {
                    ++cn;
                }
            } else {
                ++cnts[cn - 1];
            }
            pc = c;
        }
        cn -= (cnts[cn - 1] == 0 ? 1 : 0);
        cnts = Arrays.copyOf(cnts, cn);
        long mod = 1_000_000_000 + 7;
        long ans = 1;
        for (int cnt : cnts) {
            ans = (ans * (cnt + 1)) % mod;
        }
        if (k > 0) {
            long[] dp = new long[k], pdp = new long[k];
            pdp[0] = 1;
            for (int cnt : cnts) {
                long ts = 0;
                for (int l = 0; l < k; ++l) {
                    ts += pdp[l];
                    if (l - cnt > 0) {
                        ts -= pdp[l - cnt - 1];
                    }
                    dp[l] = ts % mod;
                }
                long[] tmp = pdp; pdp = dp; dp = tmp;
            }
            for (long cnt : pdp) {
                ans = (ans + mod - cnt) % mod;
            }
        }
        return (int) ans;
    }
}