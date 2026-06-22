class Solution {
    

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();

        bt(0, s, new ArrayList<>(), res);
        return res;
    }

    private void bt(int idx, String s, List<String> ds,  List<List<String>> res){
        if(idx == s.length()){
            res.add(new ArrayList<>(ds));
        }

        for(int start = idx; start < s.length(); start++){
            if(isPalindrome(s, idx, start)){
                ds.add(s.substring(idx,start+1));
                bt(start+1, s, ds, res);
                ds.remove(ds.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s, int l, int r){
        while(l<r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
