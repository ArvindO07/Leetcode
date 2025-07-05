class Solution {
    public int findLucky(int[] arr) {

        int len = arr.length;

        HashMap<Integer,Integer> mp = new HashMap<>();
        int luckyNO = -1;

        for(int i = 0;i < len; i++){
            mp.put(arr[i],mp.getOrDefault(arr[i],0) + 1);
    
        }

        for(int key : mp.keySet()){
            int value = mp.get(key);
            if(key == value && luckyNO < value) {
                luckyNO = value;
            }
        }

        return luckyNO;
        
    }
}