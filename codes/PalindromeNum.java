package project.leetcode;
/*
* 题目:https://leetcode.com/problems/palindrome-number/description/
* 数字回文串
*/
public class PalindromeNum {
	public static boolean isPalindrome(int x) {
	
			int res=0;
			int a=x;
			int b=0;
			while(x!=0){
				b=x%10;
				res=res*10+b;
				x/=10;
			}
			System.out.println(res+" "+a);
			
			if(res==a)
				return true;
			else
			   return false;
    }
	
}
