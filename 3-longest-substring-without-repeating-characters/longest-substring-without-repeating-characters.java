class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int ans = 0;
        int countlen = 0;
        HashMap<Character,Integer> mp = new HashMap<>();
        int l = 0;
        int r = 0;
        while(l < len && r < len){
            if(mp.containsKey(s.charAt(r)) && mp.get(s.charAt(r)) >= l ){                
                l = mp.get(s.charAt(r)) + 1;
                mp.put(s.charAt(r), r);
            }else {
                mp.put(s.charAt(r),r);
            }
            int temp = r-l+1;
            ans = Math.max(ans,temp);
            r++;
        }
        return ans;

    }
}