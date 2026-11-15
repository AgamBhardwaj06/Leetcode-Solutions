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
    public void traverse(TreeNode root,List<Integer>res){
        if(root==null){
            return;
        }
        Stack<TreeNode>st1=new Stack<>();
        Stack<TreeNode>st2=new Stack<>();
        st1.push(root);
        while(!st1.isEmpty()){
            TreeNode temp=st1.pop();
            st2.push(temp);
            if(temp.left!=null){
                st1.push(temp.left);
            }
            if(temp.right!=null){
                st1.push(temp.right);
            }
        }
        while(!st2.isEmpty()){
            res.add(st2.pop().val);
        }
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer>res=new ArrayList<>();
        traverse(root,res);
        return res;
    }
}