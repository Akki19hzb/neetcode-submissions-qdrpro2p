class Solution {

    public String encode(List<String> strs) {
        StringBuffer s = new StringBuffer();
        for(String str : strs){
            s.append(str.length())
            .append("#")
            .append(str);
        }
        return s.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();

        int i=0;
        int slen= str.length();

        while(i<slen){
            int j =i;

            while(str.charAt(j) !='#'){
                j++;
            }

            int len = Integer.parseInt(str.substring(i,j));
            j++; // passing the #
            String word = str.substring(j, j+len);
            ans.add(word);
            i = j+len;
        }
        return ans;
    }
}
