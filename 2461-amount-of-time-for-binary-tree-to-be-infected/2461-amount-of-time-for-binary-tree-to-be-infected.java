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
    TreeNode target=null;
    public void inorder(TreeNode root,HashMap<TreeNode,TreeNode>parent_map,int start){
        if(root==null)return;
        if(root.val==start)target=root;
        if(root.left!=null){
            parent_map.put(root.left,root);
            inorder(root.left,parent_map,start);
        }
        if(root.right!=null){
            parent_map.put(root.right,root);
            inorder(root.right,parent_map,start);
        }
    }
    public int time_taken(TreeNode target,HashMap<TreeNode,TreeNode>parent_map,HashSet<TreeNode>visited){
        Queue<TreeNode>qu=new LinkedList<>();
        qu.offer(target);
        visited.add(target);
        int time=0;
        while(!qu.isEmpty()){
            int n=qu.size();
            while(n!=0){
                TreeNode curr=qu.poll();
                if(curr.left!=null && !visited.contains(curr.left)){
                    qu.offer(curr.left);
                    visited.add(curr.left);
                }
                if(curr.right!=null && !visited.contains(curr.right)){
                    qu.offer(curr.right);
                    visited.add(curr.right);
                }
                if(parent_map.containsKey(curr)&&!visited.contains(parent_map.get(curr))){
                    qu.offer(parent_map.get(curr));
                    visited.add(parent_map.get(curr));
                }
                n--;
            }
            time++;
        }
        return time-1;
    }
    public int amountOfTime(TreeNode root, int start) {
        HashMap<TreeNode,TreeNode>parent_map=new HashMap<>();
        HashSet<TreeNode>visited=new HashSet<>();
        inorder(root,parent_map,start);
        return time_taken(target,parent_map,visited);
    }
}