class Solution {
    public int[] productQueries(int n, int[][] queries) {
        int MOD = (int) (1e9 + 7);
        int len = queries.length;
        List<Integer> power = new ArrayList<>();

        for(int i = 0 ; i < 31 ; i++){ 
            if((n >> i & 1) == 1){
                power.add(1 << i);
            }
        }

        int[] ans = new int[len];

        for(int i = 0 ; i < len ; i++){
            int left = queries[i][0];
            int right = queries[i][1];
            long product = 1;
            for(int j = left ; j <= right ; j++){
                product = (product * power.get(j)) % MOD;
            }

            ans[i] = (int)product;
        }
    return ans;
    }
}