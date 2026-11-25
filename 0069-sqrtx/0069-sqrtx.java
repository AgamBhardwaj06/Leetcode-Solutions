class Solution {
    public int mySqrt(int x) {
        if(x<2)return x;
        long ans=1;
        long low=1;
        long high=x/2;
        while(low<=high){
            long mid=low+(high-low)/2;
            long val=mid*mid;
            if(val<=x){
                ans=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return (int)ans;
    }
}