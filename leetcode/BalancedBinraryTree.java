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

//简洁做法
public boolean isBalancedTree(TreeNode root){
		return maxDepth(root)==-1?false:true;
	}
		
		

public int maxDepth(TreeNode node){
		if(node==null)
			return 0;
		int lH=height(node.left)
		if(lH==-1)
			return -1;
		int rH=height(node.right)
		ig(rH==-1)
			return -1;

		if(Math.abs(lH-rH)>1)
			return -1;

		return Math.max(lH,rH)+1;
	}
		
}
