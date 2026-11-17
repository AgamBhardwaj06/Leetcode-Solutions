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
 class Pair{
    TreeNode node;
    int col;
    int row;
    public Pair(TreeNode node,int col,int row){
        this.node=node;
        this.col=col;
        this.row=row;
    }
 }
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>>list=new ArrayList<>();
        if(root==null)return list;
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>>map=new TreeMap<>();
        Queue<Pair>qu=new LinkedList<>();
        qu.offer(new Pair(root,0,0));
        while(!qu.isEmpty()){
            Pair p=qu.poll();
            TreeNode node=p.node;
            int col=p.col;
            int row=p.row;
            if(!map.containsKey(col)){
                map.put(col,new TreeMap<>());
            }
            if(!map.get(col).containsKey(row)){
                map.get(col).put(row,new PriorityQueue<>());
            }
            map.get(col).get(row).offer(node.val);
            if(node.left!=null){
                qu.offer(new Pair(node.left,col-1,row+1));
            }
            if(node.right!=null){
                qu.offer(new Pair(node.right,col+1,row+1));
            }
        }
        for(TreeMap<Integer,PriorityQueue<Integer>>rowMap:map.values()){
            List<Integer>col_list=new ArrayList<>();
            for(PriorityQueue<Integer>node:rowMap.values()){
                while(!node.isEmpty()){
                    col_list.add(node.poll());
                }
            }
            list.add(col_list);
        }
        return list;
    }
}