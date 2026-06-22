class Solution {
    

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();

        bt(0, s, new ArrayList<>(), res);
        return res;
    }

    private void bt(int start, String s, List<String> ds,  List<List<String>> res){
        if(start == s.length()){
            res.add(new ArrayList<>(ds));
        }

        for(int end = start; end < s.length(); end++){
            if(isPalindrome(s, start, end)){
                ds.add(s.substring(start,end+1));
                bt(end+1, s, ds, res);
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
