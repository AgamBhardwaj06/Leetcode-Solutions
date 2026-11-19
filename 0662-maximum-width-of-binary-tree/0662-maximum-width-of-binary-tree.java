/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Pair{
    TreeNode node;
    int idx;
    public Pair(TreeNode node,int idx){
        this.node=node;
        this.idx=idx;
    }
}
class Solution {
    public int max_width(TreeNode root){
        if(root==null)return 1;
        int max_w=0;
        Deque<Pair>qu=new LinkedList<>();
        qu.offer(new Pair(root,0));
        while(!qu.isEmpty()){
            int n=qu.size();
            int left_idx=qu.getFirst().idx;
            int right_idx=qu.getLast().idx;
            max_w=Math.max(max_w,right_idx-left_idx+1);
            while(n!=0){
                Pair p=qu.poll();
                TreeNode node=p.node;
                int i=p.idx;
                if(node.left!=null){
                    qu.offer(new Pair(node.left,2*i+1));
                }
                if(node.right!=null){
                    qu.offer(new Pair(node.right,2*i+2));
                }
                n--;
            }
        }
        return max_w;
    }
    public int widthOfBinaryTree(TreeNode root) {
        return max_width(root);
    }
}