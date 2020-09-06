package alogrithm.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author created by wuwt
 * @date 2020/4/12 3:40 下午
 * 返回生成所有括号的可能性
 **/
public class generateParenthesis_22 {
    public List<String> generateParenthesis(int n) {
        List<String>  res = new ArrayList<>();
        //执行深度遍历
        helper(n,n,"",res);
        return res;
    }

    private void helper(int left, int right, String s, List<String> res) {
        if(left<0||right<0||left>right)
            return ;
        // 递归终止
        if(left==0&&right==0){
            res.add(s);
        }
        //每次使用一个左括号和右括号
        helper(left-1,right,s+"(",res);
        helper(left,right-1,s+")",res);

    }

    public static void main(String[] args) {

        List<String> res = new generateParenthesis_22().generateParenthesis(3);
        for(String s:res)
            System.out.println(s);
    }
}
