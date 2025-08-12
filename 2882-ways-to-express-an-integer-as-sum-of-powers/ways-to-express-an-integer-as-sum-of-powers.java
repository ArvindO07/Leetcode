class Solution {
    static final int MOD = 1_000_000_007;
    public int numberOfWays(int n, int x) {

        int power[] = new int[n+1];
        power[0] = 1;
        int s=2,count=1;

        for(int i=1;i<n;i++){
            int mul = 1;
            for(int j=0;j<x;j++){
                mul = mul*s;
            }
            if(mul <= n){
                power[count++] = mul;
            }
            else{
                break;
            }
            s++;
           
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 0; i < count; i++) {
            int p = power[i];
            for (int sum = n; sum >= p; sum--) {
                dp[sum] = (dp[sum] + dp[sum - p]) % MOD;
            }
        }

        return dp[n];
        
    }
}