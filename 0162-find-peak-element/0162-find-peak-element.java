class Solution {
    public int findPeakElement(int[] nums) {
        int low=1;
        int high=nums.length-2;
        int n=nums.length;
        if(nums.length==1)return 0;
        if(nums[0]>nums[1])return 0;
        if(nums[n-1]>nums[n-2]) return n-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if((mid-1 >=0 && mid+1 <nums.length) && nums[mid-1]<nums[mid] && nums[mid]>nums[mid+1]){
                return mid;
            }
            else if((mid-1>=0) && nums[mid]>nums[mid-1]){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return 0;
    }
}