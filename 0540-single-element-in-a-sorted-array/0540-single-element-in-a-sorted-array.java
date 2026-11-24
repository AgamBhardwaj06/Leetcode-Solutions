class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low=0;
        int high=nums.length-1;
        if(nums.length==1)return nums[0];
        if(nums[nums.length-1]!=nums[nums.length-2])return nums[nums.length-1];
        if(nums[0]!=nums[1])return nums[0];
        while(low<=high){
            int mid=low+(high-low)/2;
            if((mid-1>=0 && mid+1<nums.length) && nums[mid+1]!=nums[mid] && nums[mid-1]!=nums[mid]){
                return nums[mid];
            }
            else if((mid%2==0 && nums[mid]==nums[mid+1])||(mid%2==1 && nums[mid-1]==nums[mid])){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return -1;
    }
}