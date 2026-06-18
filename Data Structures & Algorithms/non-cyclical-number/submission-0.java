class Solution {
    public boolean isHappy(int n) {
        if(n==1) return true;
        Set<Integer> hs = new HashSet<>();
        hs.add(n);
        
        int sum=0;
        while(true){
            while(n>0){
                int a = n%10;
                sum += a*a;
                n = n/10;
            }
            n = sum;
            sum =0;
            if(n==1) return true;
            if(hs.contains(n)) return false;
            hs.add(n);
        }
    }
}
