package project.leetcode;

/*
 * https://leetcode.com/problems/balanced-binary-tree/description/
 * 给定一个二叉树，判断它是否是高度平衡的。一棵高度平衡的二叉树是左右子树的高度相差不超过1，
 * 对其左右子树也是如此。
 */
public class BalancedBinraryTree {
	
	private int minDepth=0;
	private int maxDepth=0;
	
	public boolean isBalanced(TreeNode root){
		if(root==null)
			return true;
		
		int left=depth(root.left);
		int  right=depth(root.right);
		
		if(left-right>1||left-right<-1){
			return  false;
		}
		else
			return isBalanced(root.left)&&isBalanced(root.right);
			
	}
	/*
	 * 求树的高度
	 * @param  n 树的根节点
	 * @ return 树的高度
	 */
	public int depth(TreeNode n)
	{  
		if(n==null)
			return 0;
		if(n.left==null&&n.right==null)
			return 1;
		else{
			int left=depth(n.left);
			int right=depth(n.right);			
			return 1+(left>right?left:right);
		}
			
	}
		public boolean isBalancedTree(TreeNode root){
			if(root==null)
				return true;
			if(root.left==null||root.right==null)
				return true;
			if(Math.abs(getHeight(root.left)-getHeight(root.right))>1)
				return false;
			return isBalancedTree(root.left)&&isBalancedTree(root.right);
		}
		
		public int getHeight(TreeNode root){
			if(root==null)
				return 0;
			return 1+Math.max(getHeight(root.left), getHeight(root.right));
		}
		
}
