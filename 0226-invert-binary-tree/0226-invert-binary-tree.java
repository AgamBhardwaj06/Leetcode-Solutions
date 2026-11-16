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
    public void invert(TreeNode root){
        Queue<TreeNode>qu=new LinkedList<>();
        qu.offer(root);
        while(!qu.isEmpty()){
            int n=qu.size();
            while(n>0){
                TreeNode node=qu.poll();
                if(node.left!=null || node.right!=null){
                    TreeNode temp=node.left;
                    node.left=node.right;
                    node.right=temp;
                }
                if(node.left!=null){
                    qu.offer(node.left);
                }
                if(node.right!=null){
                    qu.offer(node.right);
                }
                n--;
            }
        }
    }
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return root;
        // TreeNode temp=root.left;
        // root.left=root.right;
        // root.right=temp;
        // invertTree(root.left);
        // invertTree(root.right);
        invert(root);
        return root;
    }
}