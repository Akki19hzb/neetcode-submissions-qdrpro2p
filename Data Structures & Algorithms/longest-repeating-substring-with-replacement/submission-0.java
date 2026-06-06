class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();

        int l=0, r=0;
        int ans =0;
        HashMap<Character,Integer> hm = new HashMap<>();
        int maxFreq = 0;

        while(r<n){
            char c= s.charAt(r);
            hm.put(c, hm.getOrDefault(c,0)+1);
            maxFreq = Math.max(maxFreq, hm.get(c));

            while(r-l+1 -maxFreq >k){
                char cl = s.charAt(l);
                hm.put(cl, hm.get(cl)-1);
                l++;
            }
            ans = Math.max(ans, r-l+1);
            r++;
        }
        return ans;
    }
}
