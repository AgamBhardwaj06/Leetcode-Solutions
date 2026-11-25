class Solution {
    public int div_sum(int[] nums,int threshold,int divisor){
        double sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=Math.ceil((double)nums[i]/divisor);
        }
        return (int)sum;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int low=1;
        int high=0;
        int res=0;
        for(int num:nums){
            high=Math.max(high,num);
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            int sum=div_sum(nums,threshold,mid);
            if(sum<=threshold){
                res=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return res;
    }
}