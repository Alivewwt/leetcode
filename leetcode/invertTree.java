/*
*Invert a binary tree.

     4
   /   \
  2     7
 / \   / \
1   3 6   9
to
     4
   /   \
  7     2
 / \   / \
9   6 3   1

*https://leetcode.com/problems/invert-binary-tree/description/
*/
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
    public TreeNode invertTree(TreeNode root) {
        if(root==null)
            return null;
         else 
         {
            TreeNode temp=root.left;
             root.left=root.right;
             root.right=temp;
             
            invertTree(root.right);
            invertTree(root.left);
         }
         /*
         *invertTreeNode(root);
         */
        return root;        
    }

    public void invertTreeNode(TreeNode root){
    	if(root!=null){
    		
            TreeNode temp=root.left;
             root.left=root.right;
             root.right=temp;
             
            invertTree(root.right);
            invertTree(root.left);
    	}

    }
   
}