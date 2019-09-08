/**
 *  
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*
* 题目:https://leetcode.com/problems/binary-tree-inorder-traversal/description/
* 对一棵树进行中序遍历
* 定义一个队列，先遍历左孩子节点，若左孩子为空了，则将当前节点出栈
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
