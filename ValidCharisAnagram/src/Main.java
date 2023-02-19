public class Main {
    //验证字符是否为异位词
    /*
    给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
    注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
     */
    public static void main(String[] args) {
        String s1="anagram",t1="nagaram";
        String s2="rat",t2="car";
        Solution s= new Solution();
        System.out.println(s.isAnagram(s1, t1));
        System.out.println(s.isAnagram(s2, t2));
    }
}
class Solution {
    //解法1,统计s和t的单次出现的总次数并进行比较，如果相同就是字母异位词，否则不是
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false;
        int []sCount=new int[26];
        int []tCount=new int[26];
        for(int i=0;i<s.length();i++){
            sCount[s.charAt(i)-'a']++;
            tCount[t.charAt(i)-'a']++;
        }
        for (int i=0;i<26;i++){
            if (sCount[i]!=tCount[i])
                return false;
        }
        return true;
    }
    //解法2,
    public boolean isAnagram1(String s, String t) {
        if(s.length()!=t.length())
            return false;
        int []sCount=new int[26];
        int []tCount=new int[26];
        for(int i=0;i<s.length();i++){
            sCount[s.charAt(i)-'a']++;
            tCount[t.charAt(i)-'a']++;
        }
        for (int i=0;i<26;i++){
            if (sCount[i]!=tCount[i])
                return false;
        }
        return true;
    }
}