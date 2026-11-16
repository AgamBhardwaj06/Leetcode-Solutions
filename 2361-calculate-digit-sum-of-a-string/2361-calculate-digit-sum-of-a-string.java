class Solution {
    public void sum(String s ,int k,StringBuilder sb){
        int count=0;
        int sum=0;
        for(int i=0;i<s.length();i++){
            count++;
            sum+=s.charAt(i)-'0';
            if(count==k){
                sb.append(sum);
                count=0;
                sum=0;
            }
        }
        s=sb.toString();
        if(count>0){
             sb.append(sum);
            sum=0;
            count=0;
        }
    }
    public String digitSum(String s, int k) {
        while(s.length()>k){
            StringBuilder sb=new StringBuilder();
            int count=0;
            int sum=0;
            for(int i=0;i<s.length();i++){
                count++;
                sum+=s.charAt(i)-'0';
                if(count==k){
                    sb.append(sum);
                    count=0;
                    sum=0;
                }
            }
            if(count>0){
                sb.append(sum);
            }
            s=sb.toString();
        }
        return s;
    }
}