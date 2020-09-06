package alogrithm.medium;

import alogrithm.easy.TreeNode;

import java.util.*;

/**
 * @author created by wuwt
 * @date 2020/8/31 9:24 下午
 * 锯齿形状遍历二叉树
 **/
public class zigzagLevelOrder_103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>>  res = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        boolean flag = false;
        while(!queue.isEmpty()){
            List<Integer> temp = new ArrayList<>();
//            int size = queue.size();
            for(int i=0;i<queue.size();i++){
                TreeNode node = queue.poll();
                
                temp.add(node.val);
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
            System.out.println(temp);
            if(flag){
                Collections.reverse(temp);
                flag = false;
            }else{
                flag = true;
            }
            res.add(temp);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = null;
        root.left.right = null;
        root.right.left =null;
        root.right.left =null;

        List<List<Integer>>  res = new zigzagLevelOrder_103().zigzagLevelOrder(root);
//        System.out.println(res);
    }
}
