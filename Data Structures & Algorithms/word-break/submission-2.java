class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();

        Set<String> set = new HashSet<>(wordDict);
        int maxLen=0;
        for(String str : wordDict){
            maxLen = Math.max(maxLen, str.length());
        }

        boolean[] dp = new boolean[n+1];
        dp[0]= true; // empty string

        for(int i=1; i<=n;i++){
            for(int j=i; j>= Math.max(i-maxLen, 0); j--){
                if(dp[j] && set.contains(s.substring(j,i))){
                    dp[i] =true;
                }
            }
        }
        return dp[n];

    }
}
