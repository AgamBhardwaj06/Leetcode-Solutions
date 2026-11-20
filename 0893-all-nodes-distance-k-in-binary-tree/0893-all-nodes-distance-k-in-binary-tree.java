/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void inorder(TreeNode root,HashMap<TreeNode,TreeNode>parent_map){
        if(root==null)return;
        if(root.left!=null){
            parent_map.put(root.left,root);
            inorder(root.left,parent_map);
        }
        if(root.right!=null){
            parent_map.put(root.right,root);
            inorder(root.right,parent_map);
        }
    }
    public void BFS(TreeNode root,HashMap<TreeNode,TreeNode>parent_map,HashSet<TreeNode>visited,List<Integer>res,int k,TreeNode target){
        if(root==null)return;
        Queue<TreeNode>qu=new LinkedList<>();
        qu.offer(target);
        visited.add(target);
        while(!qu.isEmpty()){
            int n=qu.size();
            if(k==0)break;
            while(n!=0){
                TreeNode curr=qu.poll();
                if(curr.left!=null&& !visited.contains(curr.left)){
                    qu.offer(curr.left);
                    visited.add(curr.left);
                }
                if(curr.right!=null&& !visited.contains(curr.right)){
                    qu.offer(curr.right);
                    visited.add(curr.right);
                }
                if(parent_map.containsKey(curr)&&!visited.contains(parent_map.get(curr))){
                    qu.offer(parent_map.get(curr));
                    visited.add(parent_map.get(curr));
                }
                n--;
            }
            k--;
        }
        while(!qu.isEmpty()){
            res.add(qu.poll().val);
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer>res=new ArrayList<>();
        HashMap<TreeNode,TreeNode>parent_map=new HashMap<>();
        HashSet<TreeNode>visited=new HashSet<>();
        inorder(root,parent_map);
        BFS(root,parent_map,visited,res,k,target);
        return res;
    }
}