package alogrithm.medium;

import alogrithm.easy.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author created by wuwt
 * @date 2020/5/10 11:04 上午
 * 两个节点最近公共父节点
 **/
public class lowestCommonAncestor_236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //当root 为p或q，即为公共节点
        if(root==null||root==p||root==q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left==null&&right==null) return null;
        if(left==null) return  right;
        if(right==null) return left;
        return root;//(left!=null&&right!=null)
    }
    Map<Integer, TreeNode> parent = new HashMap<Integer, TreeNode>();
    Set<Integer> visited = new HashSet<Integer>();
    public void dfs(TreeNode root){
        if(root.left!=null){
            parent.put(root.left.val,root);
            dfs(root.left);
        }
        if(root.right!=null){
            parent.put(root.right.val,root);
            dfs(root.right);
        }
    }


    public TreeNode lowestCommonAncestor_1(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        //不断访问p的祖先节点
        while(p!=null){
            visited.add(p.val);
            p = parent.get(p.val);
        }
        // 不断访问q的祖先节点
        while(q!=null){
            //如果q已经被访问过，则q是p和q的祖先节点
            if(visited.contains(q.val))
                return q;
            q = parent.get(q.val);
        }
        return null;

    }
}
