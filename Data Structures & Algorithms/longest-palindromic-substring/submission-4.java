class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();

        int resLen =0;
        int resIndex =0;

        for(int i=0; i<n; i++){

            //odd length
            int l =i, r=i;
            while(l>=0 && r<n && s.charAt(l) == s.charAt(r)){
                int len = r-l+1;
              
                if(len > resLen){
                    resLen = len;
                    resIndex = l;
                }
                l--;
                r++;
            }

            //event length
            l=i; r=i+1;
            while(l>=0 && r<n && s.charAt(l) == s.charAt(r)){
                int len = r-l+1;

                if(len > resLen){
                    resLen = len;
                    resIndex = l;
                }
                l--;
                r++;
            }
        }
        return s.substring(resIndex, resIndex+resLen);
    }
}
