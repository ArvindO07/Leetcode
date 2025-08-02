class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer,Integer> map = new HashMap<>();
        int min=Integer.MAX_VALUE;
        for(int B1 : basket1){
            map.put(B1,map.getOrDefault(B1,0)+1);
            min=Math.min(min,B1);
        }
        for(int B2 : basket2){
            map.put(B2,map.getOrDefault(B2,0)-1);
             min=Math.min(min,B2);
        }
        List<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int key=entry.getKey();
            int value=entry.getValue();

            if(value%2!=0){
                return -1;
            }
            for(int i=0; i<Math.abs(value)/2; i++){
                list.add(key);
            }
        }
        Collections.sort(list);
        long result=0;
        for(int i=0; i<list.size()/2; i++){
            result+=Math.min(list.get(i),min*2);
        }
        return result;
    }
}