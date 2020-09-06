package alogrithm.medium;

import alogrithm.easy.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author created by wuwt
 * @date 2020/4/22 9:09 下午
 **/
public class rightSideView_199 {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root==null)
            return res;
        //存储结果列表
        Queue<TreeNode> que  = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()){
            //层次遍历
            int size = que.size();
            for(int i=0;i<size;i++){
                TreeNode node = que.poll();
                if(i==size-1) res.add(node.val);
                if(node.left!=null)
                    que.add(node.left);
                if(node.right!=null)
                    que.add(node.right);
            }

        }
        return res;
    }
}
