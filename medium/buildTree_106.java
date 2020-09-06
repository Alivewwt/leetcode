package alogrithm.medium;

import alogrithm.easy.TreeNode;

/**
 * @author created by wuwt
 * @date 2020/4/12 10:25 下午
 * 根据中序和后序来建立二叉树
 * [左、根、右] [左、右、根]
 **/
public class buildTree_106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder==null || inorder.length<1)
            return null;
        return buildTree(inorder,0,inorder.length-1, postorder, 0, postorder.length-1);

    }

    private TreeNode buildTree(int[] inorder, int ileft, int iright, int[] postorder, int pleft, int pright) {
        if(ileft>iright||pleft>pright)
            return null;
        //根节点
        int i = postorder[pright];
        TreeNode node = new TreeNode(i);
        int index = 0;
        while (inorder[index]!=i){
            index++;
        }
        int len = index-ileft;
        node.left = buildTree(inorder,ileft,len-1,postorder,pleft,pleft+len-1);
        node.right = buildTree(inorder,len+1,iright,postorder,pleft+len,pright-1);
        return node;
    }
}
