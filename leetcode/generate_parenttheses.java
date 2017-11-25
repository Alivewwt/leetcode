/*
For example, given n = 3, a solution set is:
[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
*/
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list=new ArrayList<String>();
        String str="";
        generateoneByone(list,str,n,n);
        return list;
    }
    
    public void generateoneByone(List<String> list,String str,int left,int right){
        if(left>right)
            return ;
        if(left>0)
            generateoneByone(list,str+'(',left-1,right);
        if(right>0)
            generateoneByone(list,str+')',left,right-1);
        if(left==0&&right==0){
              list.add(str);
            return;
        }
          
    }
}