class Solution {
    public int calPoints(String[] operations) {
        Stack<String>st=new Stack<>();
        for(String s:operations){
            if(!st.isEmpty() && s.equals("C")){
                st.pop();
            }else if(!st.isEmpty() && s.equals("D")){
                int num=Integer.valueOf(st.peek());
                num=num*2;
                String new_score=num+"";
                st.push(new_score);
            }else if(st.size()>=2 && s.equals("+")){
                int num1=Integer.valueOf(st.peek());
                String temp=st.pop();
                int num2=Integer.valueOf(st.peek());
                int num=num1+num2;
                st.push(temp);
                String new_score=num+"";
                st.push(new_score);
            }else{
                st.push(s);
            }
        }
        int final_score=0;
        while(!st.isEmpty()){
            int score=Integer.valueOf(st.pop());
            final_score+=score;
        }
        return final_score;
    }
}