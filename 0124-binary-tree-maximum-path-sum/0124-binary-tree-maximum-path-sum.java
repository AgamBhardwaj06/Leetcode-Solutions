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
    int maxsum=Integer.MIN_VALUE;
    public int max(TreeNode root){
        if(root==null)return 0;
        int lr=max(root.left);
        int rr=max(root.right);

        int root_child_sum=root.val+lr+rr;
        int child_sum=root.val+Math.max(lr,rr);
        int root_sum=root.val;
        maxsum=Math.max(maxsum,Math.max(root_child_sum,Math.max(child_sum,root_sum)));
        return Math.max(child_sum,root_sum);
    }
    public int maxPathSum(TreeNode root) {
        max(root);
        return maxsum;
    }
}