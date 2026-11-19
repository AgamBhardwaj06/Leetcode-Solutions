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
    public void preorder(TreeNode root,List<TreeNode>res){
        if(root==null)return;
        res.add(root);
        preorder(root.left,res);
        preorder(root.right,res);
    }
    public void flatten(TreeNode root) {
        List<TreeNode>res=new ArrayList<>();
        preorder(root,res);
        if(root!=null)res.remove(0);
        TreeNode node=root;
        for(int i=0;i<res.size();i++){
            node.left=null;
            node.right=res.get(i);
            node=node.right;
        }
    }
}