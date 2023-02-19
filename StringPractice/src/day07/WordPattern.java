package day07;

import java.util.HashMap;

public class WordPattern {
    //单词规律
    /*
    给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
    这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 s 中的每个非空单词之间存在着双向连接的对应规律。
    例如：
    输入: pattern = "abba", s = "dog cat cat dog"
    输出: true
    输入:pattern = "abba", s = "dog cat cat fish"
    输出: false
    输入: pattern = "aaaa", s = "dog cat cat dog"
    输出: false
     */
    public static void main(String[] args) {
        WordPattern s =new WordPattern();
        System.out.println(s.wordPattern("abba", "dog cat cat dog")); //true
        System.out.println(s.wordPattern("abba", "dog cat cat fish"));   //false
        System.out.println(s.wordPattern("aaaa", "dog cat cat dog"));//false
        System.out.println(s.wordPattern("aaaa", "dog dog dog dog"));//true
        System.out.println(s.wordPattern("a","dog cat"));//false
        System.out.println(s.wordPattern("abba","dog dog dog dog"));//false
    }
    public boolean wordPattern(String pattern, String s) {
        String [] str = s.split(" ");//根据空格拆分字符串s
        if(pattern.length()  != str.length){
            return false;//当拆分字符串数组的长度和pattern的字符串的长度不一致时。
        }
        HashMap<Character,String> mp = new HashMap<>();
        char c;
        String tmp;
        //遍历字符串
        for(int i=0;i< str.length;i++){
            c=pattern.charAt(i);
            tmp = str[i];
            if(mp.containsKey(c)){//如果该map映射存在
                if(!mp.get(c).equals(tmp))
                    return false;//该字符对应的单词与其在哈希表中的映射值不一致
            }else {//如果该map映射不存在，则添加相对应的map映射
                if(mp.containsValue(tmp))//保证一个单词只能更一个pattern中的字符一一对应
                    return false;
                mp.put(c,tmp);
            }
        }
        return true;
    }
}
