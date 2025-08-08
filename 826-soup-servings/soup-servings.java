class Solution {
    public double soupServings(int N) {
        if(N>5000) return 1;

        int n = (int) Math.ceil(N / 25.0);
        double[][] dp = new double[n+1][n+1];
        for(double[] arr: dp){
            Arrays.fill(arr,-1);
        }

        return helper(n,n,dp);
    }

    public double helper(int a,int b, double[][] dp){
        if(a<=0 && b<=0) return 0.5;
        if(a<=0) return 1;
        if(b<= 0) return 0;

        if(dp[a][b] != -1) return dp[a][b];

        dp[a][b] = 0.25*(
                    helper(a-4,b,dp)+helper(a-3,b-1,dp)
                    +helper(a-2,b-2,dp)+helper(a-1,b-3,dp)
        );

        return dp[a][b];
    }
}