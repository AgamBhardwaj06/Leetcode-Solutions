class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low=0;
        int high=0;
        for(int weight:weights){
            low=Math.max(weight,low);
            high+=weight;
        }
        int res=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            int d=1;
            int w=0;
            for(int i=0;i<weights.length;i++){
                if(w+weights[i]>mid){
                    d++;
                    w=weights[i];
                }else{
                    w+=weights[i];
                }
            }
            if(d<=days){
                res=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return res;
    }
}