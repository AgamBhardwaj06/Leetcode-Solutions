class Solution {
    public int search(int[]nums,int target,boolean left_idx){
        int low=0;
        int high=nums.length-1;
        int idx=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                idx=mid;
                if(left_idx){
                    high=mid-1;
                }
                else{
                    low=mid+1;
                }
            }else if(nums[mid]<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return idx;
    }
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==0) return new int[]{-1,-1};
        int first_idx=search(nums,target,true);
        int last_idx=search(nums,target,false);
        return new int[]{first_idx,last_idx};
    }
}