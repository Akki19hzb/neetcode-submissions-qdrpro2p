class Solution {
    public double myPow(double x, int n) {
        double res =1;
        if(n <0){
            n= n* -1;
            x = 1/x;
        }

        while(n>0){
            
            res = res * x;
            n--;
        }
        return res;
    }
}
