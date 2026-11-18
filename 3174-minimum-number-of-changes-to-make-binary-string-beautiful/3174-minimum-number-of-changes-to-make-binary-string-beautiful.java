class Solution {
    public int minChanges(String s) {
        int min_count=0;
        for(int i=0;i<s.length()-1;i+=2){
            StringBuilder sb=new StringBuilder();
            char ch=(s.charAt(i));
            char next_ch=s.charAt(i+1);
            if(ch!=next_ch){
                min_count++;
            }
        }
        return min_count;
    }
}