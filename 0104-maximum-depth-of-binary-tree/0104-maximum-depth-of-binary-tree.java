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
    // public int depth(TreeNode root){
    //     int d=0;
    //     if(root==null)return d;
    //     Queue<TreeNode>qu=new LinkedList<>();
    //     qu.offer(root);
    //     while(!qu.isEmpty()){
    //         int n=qu.size();
    //         while(n>0){
    //             TreeNode node=qu.poll();
    //             if(node.left!=null){
    //                 qu.offer(node.left);
    //             }
    //             if(node.right!=null){
    //                 qu.offer(node.right);
    //             }
    //             n--;
    //         }
    //         d++;
    //     }
    //     return d;
    // }
    public int maxDepth(TreeNode root) {
        // return(depth(root));
        if(root==null)return 0;
        int lr=maxDepth(root.left);
        int rr=maxDepth(root.right);
        return 1+Math.max(lr,rr);
    }
}