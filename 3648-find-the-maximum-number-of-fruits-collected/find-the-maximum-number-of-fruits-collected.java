class Solution {
    int dir[][][] = new int[][][]{{{-1,1},{0,1},{1,1}},{{1,-1},{1,0},{1,1}}};
    public int recur(int i , int j , int n , int fruits[][] , int dobj,int dp[][]){
        if( i==n-1 && j==n-1 ) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int ans = 0;
        for(int d[]: dir[dobj]){
                int nx = i + d[0];
                int ny = j + d[1];
                if(nx<n && ny<n && ((nx==n-1 && ny==n-1) || (dobj==0 && nx>ny) || (dobj==1 && nx<ny))){
                    ans = Math.max(ans,fruits[i][j] + recur(nx,ny,n,fruits,dobj,dp));
                }
            }
        //System.out.println(ans + " "+ dobj);
        return dp[i][j] = ans;
    }
    public int maxCollectedFruits(int[][] fruits) {
        int colec = 0;
        int n = fruits.length;
        for(int i=0;i<n;i++) colec += fruits[i][i];
        int dp[][] =new int[n][n];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        colec += recur(n-1,0,n,fruits,0,dp);
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        colec += recur(0,n-1,n,fruits,1,dp);
        return colec;
    }
}