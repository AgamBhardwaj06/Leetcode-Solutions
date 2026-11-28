class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<tokens.length;i++){
            String s=tokens[i];
            if(st.size()>=2 && s.equals("+")){
                int num1=st.pop();
                int num2=st.pop();
                st.push(num1+num2);
            }else if(st.size()>=2 && s.equals("-")){
                int num1=st.pop();
                int num2=st.pop();
                st.push(num2-num1);
            }else if(st.size()>=2 && s.equals("/")){
                int num1=st.pop();
                int num2=st.pop();
                st.push(num2/num1);
            }else if(st.size()>=2 && s.equals("*")){
                int num1=st.pop();
                int num2=st.pop();
                st.push(num1*num2);
            }else{
                int num=Integer.valueOf(s);
                st.push(num);
            }
        }
        return st.pop();
    }
}