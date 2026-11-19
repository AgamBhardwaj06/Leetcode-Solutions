class Solution {
    public int minimizeSum(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int drop_smallest=nums[n-1]-nums[2];
        int drop_extremes=nums[n-2]-nums[1];
        int drop_largest=nums[n-3]-nums[0];
        int min_score=Math.min(drop_smallest,Math.min(drop_extremes,drop_largest));
        return min_score;
    }
}