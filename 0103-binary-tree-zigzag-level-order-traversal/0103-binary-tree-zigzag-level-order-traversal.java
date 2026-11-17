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
    public void traverse(TreeNode root,List<List<Integer>>res){
        if(root==null)return;
        Queue<TreeNode>qu=new LinkedList<>();
        qu.offer(root);
        int count=0;
        while(!qu.isEmpty()){
            int n=qu.size();
            List<Integer>temp=new ArrayList<>();
            count++;
            while(n!=0){
                TreeNode node=qu.poll();
                if(node.left!=null){
                    qu.offer(node.left);
                }
                if(node.right!=null){
                    qu.offer(node.right);
                }
                temp.add(node.val);
                n--;
            }
            if(count%2==0){
                Collections.reverse(temp);
            }
            res.add(temp);
        }
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>>res=new ArrayList<>();
        traverse(root,res);
        return res;
    }
}