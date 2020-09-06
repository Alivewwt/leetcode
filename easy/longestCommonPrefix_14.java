package alogrithm.easy;


/**
 * @author created by wuwt
 * @date 2020/6/15 8:54 下午
 * 最长公共前缀
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 **/
public class longestCommonPrefix_14 {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0||strs==null)
            return "";
        if(strs.length==1)
            return strs[0];
        String res = "";
        boolean flag1 = false;

        char char0[]= strs[0].toCharArray();
        for(int i=0;i<char0.length;i++){
            char temp = char0[i];
            boolean flag2 = false;
            for(int j=1;j<strs.length;j++){
                if(i>strs[j].length()-1){
                    flag1 = true;
                    break;
                }
                if(temp != strs[j].charAt(i)){
                    flag2 = true;
                    break;
                }
            }

            if (flag1 && flag2){
                break;
            }
            res+=String.valueOf(temp);

        }
        return  res;
    }

    public static void main(String[] args) {
        longestCommonPrefix_14 lc = new longestCommonPrefix_14();
        String[] strs = {"flower","flow","flight"};
        System.out.println(lc.longestCommonPrefix(strs));
    }
}
