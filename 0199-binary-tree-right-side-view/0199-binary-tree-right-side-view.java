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
class Solution {
    public void right_view(TreeNode root,List<Integer>res){
        if(root==null)return;
        Queue<TreeNode>qu=new LinkedList<>();
        qu.offer(root);
        while(!qu.isEmpty()){
            int n=qu.size();
            List<Integer>temp=new ArrayList<>();
            while(n!=0){
                TreeNode node=qu.poll();
                if(node.left!=null){
                    qu.offer(node.left);
                }
                if(node.right!=null){
                    qu.offer(node.right);
                }
                n--;
                temp.add(node.val);
            }
            res.add(temp.get(temp.size()-1));
        }
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer>res=new ArrayList<>();
        right_view(root,res);
        return res;
    }
}