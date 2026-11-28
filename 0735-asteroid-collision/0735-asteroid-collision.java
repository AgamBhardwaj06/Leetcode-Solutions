class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<asteroids.length;i++){
            if(asteroids[i]<0){
                while(!st.isEmpty()&& st.peek()>0 && st.peek()<Math.abs(asteroids[i])){
                        st.pop();
                }
                if(!st.isEmpty() && st.peek()==Math.abs(asteroids[i])){
                    st.pop();
                }else if(st.isEmpty()||st.peek()<0){
                    st.push(asteroids[i]);
                }
            }else{
                st.push(asteroids[i]);
            }
        }
        int []res=new int[st.size()];
        int i=0;
        for(int num:st){
            res[i++]=num;
        }
        return res;
    }
}