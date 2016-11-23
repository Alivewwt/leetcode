/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*
问题描述
对一棵树进行层次遍历，奇数行的节点不需逆置，偶数行的节点逆置
*/
public class Solution {
    //奇数行节点不需逆置
    //偶数行节点逆置
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null)
        return res;
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.offer(root);
        boolean rev=false;
        while(!queue.isEmpty()){
            int size=queue.size();
            ArrayList<Integer> level=new ArrayList<Integer>();
            for(int i=0;i<size;i++){
                TreeNode t=queue.poll();
                level.add(t.val);
                if(t.left!=null)
                    queue.offer(t.left);
                    if(t.right!=null)
                    queue.offer(t.right);
            }
            if(rev){
                 Collections.reverse(level);
            //res.add(level);
               rev=false;
            }
           else rev=true;
             res.add(level);
        }
        return res;
    }
}
