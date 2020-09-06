package alogrithm.medium;

import alogrithm.easy.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author created by wuwt
 * @date 2020/5/13 10:10 下午
 * 层次遍历
 **/
public class levelOrder_102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root==null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer>  temp = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                temp.add(node.val);
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            res.add(temp);
        }
        return res;

    }
}
