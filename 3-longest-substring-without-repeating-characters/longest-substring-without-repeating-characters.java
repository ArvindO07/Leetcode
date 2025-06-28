class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int ans = 0;
        int countlen = 0;

        for(int i = 0; i<len; i++){
            HashMap<Character,Integer> mp = new HashMap<>();
            for(int j = i ; j<len;j++){
                mp.put(s.charAt(j), mp.getOrDefault(s.charAt(j),0) + 1);
                if(mp.get(s.charAt(j)) > 1){
                    // System.out.println(mp.size() + " | " + " " + mp.get(s.charAt(i)) + " j-> " + j + " | " + s.charAt(j));
                    // ans = Math.max(mp.size(),ans);
                    break;
                }
            }
            ans = Math.max(mp.size(),ans);
        }

        return ans;

    }
}