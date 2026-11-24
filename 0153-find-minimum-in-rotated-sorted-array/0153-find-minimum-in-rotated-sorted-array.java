class Solution {
    public int findMin(int[] nums) {
        int low=0;
        int high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if((mid-1>=0 && mid+1 <nums.length)&&nums[mid+1]>nums[mid] && nums[mid-1]>nums[mid])return nums[mid];
            if(mid+1 < nums.length && nums[mid+1]<nums[mid]){
                return nums[mid+1];
            }
            else if(nums[mid]>=nums[high]){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return nums[0];
    }
}