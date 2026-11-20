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
    public int count_left(TreeNode root){
        int lh=0;
        while(root!=null){
            root=root.left;
            lh++;
        }
        return lh;
    }
    public int count_right(TreeNode root){
        int rh=0;
        while(root!=null){
            root=root.right;
            rh++;
        }
        return rh;
    }
    public int countNodes(TreeNode root) {
        if(root==null)return 0;
        int lc=count_left(root);
        int rc=count_right(root);
        if(lc==rc){
            return ((int)Math.pow(2,lc)-1);
        }
        return countNodes(root.left)+countNodes(root.right)+1;
    }
}