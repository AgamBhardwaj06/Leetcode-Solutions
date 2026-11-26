class Solution {
    public int splitArray(int[] nums, int k) {
        if(k>nums.length)return -1;
        int low=0;
        int high=0;
        for(int num:nums){
            low=Math.max(num,low);
            high+=num;
        }
        int res=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            int s=1;
            int sum=0;
            for(int i=0;i<nums.length;i++){
                if(sum+nums[i]<=mid){
                    sum+=nums[i];
                }else{
                    s++;
                    sum=nums[i];
                }
            }
            if(s<=k){
                res=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return res;
    }
}