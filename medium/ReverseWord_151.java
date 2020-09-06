package alogrithm.medium;

/**
 * @author created by wuwt
 * @date 2020/4/10 10:37 下午
 **/
public class ReverseWord_151 {
    public String reverseWords(String s) {
         s = s.trim();
         if(s.length()==0)
             return s;
         String blank =" ";
         String[] wordsArray = s.split(blank);
         StringBuilder sb = new StringBuilder();
         for(int i=wordsArray.length-1;i>=0;i--){
             String word = wordsArray[i];
             word = word.trim();
             if(word.length()>0){
                 sb.append(word).append(blank);
             }
         }
         return sb.toString().trim();

    }

    public static void main(String[] args) {
        String s = "  hello world!  ";
        System.out.println(new ReverseWord_151().reverseWords(s));
    }
}
