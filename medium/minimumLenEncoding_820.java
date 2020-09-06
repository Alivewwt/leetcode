package alogrithm.medium;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author created by wuwt
 * @date 2020/3/28 10:05 下午
 * if the list of words is ["time", "me", "bell"],
 * we can write it as S = "time#bell#" and indexes = [0, 2, 5].
 * 常规做法找到不同的词，然后再去除词里面的后缀(有后缀的都删了) ,最长的字符串里肯定包含其他短串。
 **/
public class minimumLenEncoding_820 {
    public int minimumLengthEncoding(String[] words) {
        HashSet<String> set = new HashSet<>(Arrays.asList(words));
        //遍历每个词
        for(String word: words){
            for(int i=1;i<word.length();i++){
                set.remove(word.substring(i));
            }
        }
        int res =0;
        for(String s :set){
            res += s.length()+1;//+1 是#号
        }


        return res;
    }

    public static void main(String[] args) {
        String words[] = new String[]{"time", "me", "bell"};
        new minimumLenEncoding_820().minimumLengthEncoding(words);
    }
}
