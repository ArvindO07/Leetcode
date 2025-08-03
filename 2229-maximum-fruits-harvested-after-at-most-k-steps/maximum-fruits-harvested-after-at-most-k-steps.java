class Solution {
    private int getVal(int arr[], int index) {
        return index<arr.length?arr[index]:arr[arr.length-1];
    }

    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int n = fruits.length;
        int maxPos = Math.max(fruits[n-1][0],startPos);
        int fruitsLeft[] = new int[startPos+1];
        int fruitsRight[] = new int[maxPos-startPos+1];

        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(fruits[i][0],fruits[i][1]);
        }

        int fruitsL = 0;
        int fruitsR = 0;
        for(int i=1;i<fruitsLeft.length;i++){
            fruitsL+= map.getOrDefault(startPos-i,0);
            fruitsLeft[i] = fruitsL;
        }
        for(int i=1;i<fruitsRight.length;i++){
            fruitsR+=  map.getOrDefault(startPos+i,0);
            fruitsRight[i] = fruitsR;
        }

        // goes to left then right
        int steps = 0;
        int maxFruits = 0;
        int fruitsCurr = 0;
        while(steps<k){
            fruitsCurr = getVal(fruitsLeft,steps/2) + getVal(fruitsRight,k-steps);
            maxFruits = Math.max(fruitsCurr, maxFruits);

            steps+= 2;
        }

        // goes to right then left
        steps = 0;
        fruitsCurr = 0;
        while(steps<k){
            fruitsCurr = getVal(fruitsRight,steps/2) + getVal(fruitsLeft,k-steps);
            maxFruits = Math.max(fruitsCurr, maxFruits);

            steps+= 2;
        }


        maxFruits+= map.getOrDefault(startPos,0);

        return maxFruits;
    }
}