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
    boolean flag=true;
    public int height(TreeNode root){
        if(root==null)return 0;
        int lr=height(root.left);
        int rr=height(root.right);
        if(Math.abs(lr-rr)>1)flag=false;
        return 1+Math.max(lr,rr);
    }
    public boolean isBalanced(TreeNode root) {
        if(root==null)return true;
        height(root);
        return flag;
    }
}