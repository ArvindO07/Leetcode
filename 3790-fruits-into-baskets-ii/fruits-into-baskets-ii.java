class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length, m = baskets.length, cnt = 0;
        for(int f: fruits){
            for(int j = 0; j < m; j++){
                if(f <= baskets[j]){
                    baskets[j] = -1;
                    cnt++;
                    break;
                }
            }
        }
        return n - cnt;
    }
}