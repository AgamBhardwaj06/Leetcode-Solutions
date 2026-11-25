class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int low=1;
        int high=0;
        int res=-1;
        
        for(int num:bloomDay){
            high=Math.max(high,num);
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            int d=0;
            int consecutive=0;
            for(int i=0;i<bloomDay.length;i++){
                if(bloomDay[i]<=mid){
                    consecutive++;
                    if(consecutive==k){
                        d++;
                        consecutive=0;
                    }
                }else{
                    consecutive=0;
                }
            }
            if(m<=d){
                res=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return res;
    }
}