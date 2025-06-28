class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int ans = 0;
        int countlen = 0;

        HashMap<Character,Integer> mp = new HashMap<>();

        int l = 0;
        int r = 0;

        while(l < len && r < len){
            // System.out.print("s.charAt( " + r +")-> " + s.charAt(r) + " | s.charAt(" +l+") -> " + s.charAt(l) );
            if(mp.containsKey(s.charAt(r)) && mp.get(s.charAt(r)) >= l ){
                
                l = mp.get(s.charAt(r)) + 1;
                mp.put(s.charAt(r), r);
            }else {
                mp.put(s.charAt(r),r);
            }
            int temp = r-l+1;
            // System.out.println(" | temp-> " + temp + "  | l,r-> " + l+ " , " + r + " | ans-> " + ans);
            ans = Math.max(ans,temp);
            r++;
        }


        // for(int i = 0; i<len; i++){
        //     HashMap<Character,Integer> mp = new HashMap<>();
        //     for(int j = i ; j<len;j++){
        //         mp.put(s.charAt(j), mp.getOrDefault(s.charAt(j),0) + 1);
        //         if(mp.get(s.charAt(j)) > 1){
        //             // System.out.println(mp.size() + " | " + " " + mp.get(s.charAt(i)) + " j-> " + j + " | " + s.charAt(j));
        //             // ans = Math.max(mp.size(),ans);
        //             break;
        //         }
        //     }
        //     ans = Math.max(mp.size(),ans);
        // }



        return ans;

    }
}