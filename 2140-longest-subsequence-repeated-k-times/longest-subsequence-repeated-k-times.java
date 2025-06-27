class Solution {
    String ret = "";
    int retLen = 0;
    int k;

    public String longestSubsequenceRepeatedK(String s, int k) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        this.k = k;

        int[] freq = new int[26];
        //we compute the frequency of each letter
        for (char c : ch) {
            freq[c - 'a']++;
        }

        // a character is a candidate only if its frequency is at least k
        // we populate a list of all candidates char that repeats at least k times
        List<Character> avai = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (freq[i] >= k) {
                char c = (char) ('a' + i);
                for (int j = 0; j < freq[i] / k; j++) {
                    // we add the char freq[i]/k times.
                    // for example, if the frequence is 2*k, 
                    // we add the letter twice
                    avai.add(c);
                }
            }
        }

        // subsequence must be repeated k times,
        // so the subsequence cannot exceed n / k size.
        int maxLen = n / k;

        dfs(ch, maxLen, avai, new StringBuilder());

        return ret;
    }

    void dfs(char[] ch, int maxLen, List<Character> avai, StringBuilder sofar) {
        for (int i = 0; i < avai.size(); i++) {
            // get the candidate
            char c = avai.get(i);
            sofar.append(c);
            // remove the letter from the available candidates
            avai.remove(i);
            // check if this sofar is a subsequence that repeats itself k times
            boolean ok = subseq(ch, sofar);
            if (ok) {
                // if yes, update our result
                if (sofar.length() >= retLen) {
                    ret = sofar.toString();
                    retLen = sofar.length();
                }
                // and try to find a bigger subsequence
                dfs(ch, maxLen, avai, sofar);
            }
            // perform the backtracking by resetting our candidate
            sofar.deleteCharAt(sofar.length() - 1);
            avai.add(i, c);
        }
    }

    boolean subseq(char[] ch, StringBuilder sofar) {
        // construct an array of k subsequence
        char[] seq = sofar.toString().repeat(k).toCharArray();
        int cur = 0;
        // for the gieven string, check if we can build k subsequences
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == seq[cur]) {
                cur++;
                if (cur == seq.length) {
                    return true;
                }
            }
        }
        return false;
    }
}