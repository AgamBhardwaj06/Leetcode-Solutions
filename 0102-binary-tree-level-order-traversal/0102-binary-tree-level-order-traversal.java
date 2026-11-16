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
    public void traversal(TreeNode root,List<List<Integer>>res){
        if(root==null)return;
        Queue<TreeNode>qu=new LinkedList<>();
        qu.offer(root);
        while(!qu.isEmpty()){
            int n=qu.size();
            List<Integer>ls=new ArrayList<>();
            while(n!=0){
                TreeNode node=qu.poll();
                if(node.left!=null){
                    qu.offer(node.left);
                }
                if(node.right!=null){
                    qu.offer(node.right);
                }
                ls.add(node.val);
                n--;
            }
            res.add(ls);
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>>res=new ArrayList<>();
        traversal(root,res);
        return res;
    }
}