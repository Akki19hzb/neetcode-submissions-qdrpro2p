class Solution {
    public int numDecodings(String s) {
        int n = s.length();

        int[] dp = new int[n+1];
        dp[0] =1; //empty string
        dp[1] = s.charAt(0) != '0' ? 1 :0;

        for(int i=2; i<=n;i++){
            int one =0;
            
            if(s.charAt(i-1) != '0'){
                one = dp[i-1];
            }

            int twoDigit = Integer.parseInt(s.substring(i-2, i));
            int two =0;
            if(twoDigit >=10 && twoDigit <=26){
                two = dp[i-2];
            }
            dp[i] = one + two;
        }
        return dp[n];
    }
}
