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
    int d=0;
    public int height(TreeNode root){
        if(root==null)return 0;
        int lr=height(root.left);
        int rr=height(root.right);
        d=Math.max(d,lr+rr);
        return 1+Math.max(lr,rr);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return d;
    }
}