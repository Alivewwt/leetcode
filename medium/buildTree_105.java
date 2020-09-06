package alogrithm.medium;

import alogrithm.easy.TreeNode;

/**
 * @author created by wuwt
 * @date 2020/4/11 9:02 下午
 * 先序和中序遍历，构建二叉树  [根结点 左子树 右子树] [左子树 根节点 右字树]
 **/

public class buildTree_105 {
    public TreeNode constructTree(int[] preorder, int[] inorder){
        if(preorder==null || preorder.length<1)
            return null;
        return buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1);

    }

    private TreeNode buildTree(int[] preorder,int pleft,int pright,int[] inorder,int ileft,int iright){
        if(pleft>pright||ileft>iright)
            return null;
        // 根结点
        int i = preorder[pleft];
        TreeNode  node = new TreeNode(i);
        int index = ileft;
        //寻找中序里的根结点
        while(inorder[index]!=i){
            index++;
        }
        int leftLen = index-ileft;
        node.left = buildTree(preorder,pleft+1,pleft+leftLen,inorder,ileft,index-1);
        node.right = buildTree(preorder,pleft+leftLen+1,pright,inorder,index+1,iright);
        return node;

    }
}
