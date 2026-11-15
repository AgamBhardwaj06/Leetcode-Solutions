class Solution {
    public int numOfSubarrays(int[] arr) {
        int m=1000000007;
        int sum=0;
        int prefix[]=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            prefix[i]=sum;
        }
        int count=0;
        int odd_count=0;
        int even_count=0;
        for(int i=0;i<prefix.length;i++){
            if(prefix[i]%2==0){
                count=(count+odd_count)%m;
                even_count++;
            }else{
                count=(count+even_count+1)%m;
                odd_count++;
            }
        }
        return count;
    }
}