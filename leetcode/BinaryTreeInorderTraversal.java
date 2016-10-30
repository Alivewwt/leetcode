/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list=new ArrayList<Integer>();
        if(root==null)
          return list;
        TreeNode p=root;
        Stack<TreeNode> stack=new Stack<TreeNode>();
        while(!stack.isEmpty()||p!=null){
            if(p!=null){
                stack.push(p);
                p=p.left;
            }
           else{
               TreeNode t=stack.pop();
               list.add(t.val);
               p=t.right;
           }
        }
        return list;
    }
}