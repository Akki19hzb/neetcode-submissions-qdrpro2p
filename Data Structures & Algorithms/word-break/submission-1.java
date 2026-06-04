class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);

        int n = s.length();

        boolean[] dp = new boolean[n+1];
        dp[0] =true; //empty string

        for(int i=1; i<=n; i++){
            for(int j=0; j<i; j++){
                /*this is basically 
                we fix the endpint of substring and checking likelse
                0-i
                suppose neetcode (it starts from 1 for i as 0 is empty string)
                i = 5 means at char c  
                so first check neetc
                then eetc, etc, tc, c present in set
                so suppose we are at last char e (neetcode)
                when j reaches to c, then string is code ans we find it in set 

                but to mark this as true, you must ensure just all chars before was present 
                in the set that is neet is present, so dp[j] is true

                */

                if(dp[j] && set.contains(s.substring(j,i))){
                    dp[i]= true;
                    break;
                }
            }
        }
        return dp[n];


    }
}
