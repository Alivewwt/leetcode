package project.leetcode;

import java.util.Stack;

/*
 * 题目描述 https://leetcode.com/problems/valid-parentheses/description/
 * 给定一个字符串，只包含’(‘, ‘)’, ‘{‘, ‘}’, ‘[’ 和’]’这些字符，检查它是否是“有效”的。 
 *	括号必须以正确的顺序关闭，例如”()” 和”()[]{}”都是有效的，”(]” 和”([)]”是无效的。
 */
public class validParentheses {
	/*
	 * 解题思路
	 * 一道训练栈的基础题，遇到左括号的进栈，碰到右括号，首先判断栈是否为空，若为空，证明不能匹配，如果栈不为孔，弹出top,与当前
	 * 扫描的括号检查是否匹配，等检查完了以后，判断栈是否为空，空则正确都匹配，不空则证明没有完全匹配
	 */
	public boolean isValid(String s){
		Stack<Character> stack=new Stack<>();
		char[] charArr=s.toCharArray();
		for(Character ch: charArr){
			if(ch=='(')
				stack.add(')');
			else if(ch=='{')
				stack.add('}');
			else if(ch=='[')
				stack.add(']');
			else if(stack.isEmpty()||stack.pop()!=ch)
				return  false;
		}
		return stack.isEmpty();
		
	}
}
