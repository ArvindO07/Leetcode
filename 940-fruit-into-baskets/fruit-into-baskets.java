class Solution {
    public int totalFruit(int[] fruits) 
    {
        Map<Integer,Integer> map=new HashMap<>();
        int max=0,l=0,n=fruits.length;
        for(int r=0;r<n;r++)
        {
            map.put(fruits[r],map.getOrDefault(fruits[r],0)+1);
            while(map.size()>2)
            {
                int f=fruits[l];
                map.put(f,map.get(f)-1);
                if(map.get(f)==0)
                   map.remove(f);
                l++;
            }
            max=Math.max(max,r-l+1);
        }
        return max;
    }
}