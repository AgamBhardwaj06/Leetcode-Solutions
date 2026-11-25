class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=0;
        int high=0;
        for(int num:piles){
            high=Math.max(num,high);
        }
        int ans=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            int sum=0;
            for(int i=0;i<piles.length;i++){
                sum+=Math.ceil((double)piles[i]/mid);
            }
            if(sum<=h){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
}