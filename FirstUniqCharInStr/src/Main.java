import java.util.HashMap;

public class Main {
    //字符串中的第一个唯一字符
    //给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
    public static void main(String[] args) {
        String s="leetcode";
        String s1="loveleetcode";
        String s2="aabb";
        Solution tmp =new Solution();
        System.out.println(tmp.firstUniqChar1(s));
        System.out.println(tmp.firstUniqChar1(s1));
        System.out.println(tmp.firstUniqChar1(s2));
//        System.out.println(s.lastIndexOf('l'));
    }
}
class Solution {
    //暴力破解法
    public int firstUniqChar(String s) {
        //遍历字符串
        for(int i=0;i<s.length();i++){
            //说明此字符是第一个唯一字符
            if(s.indexOf(s.charAt(i))==s.lastIndexOf(s.charAt(i))){
                   return i;
            }
        }
        return -1;
    }
    //通过与26个字母对应的数组进行计数
    public int firstUniqChar1(String s) {
        //用于记录每个字母出现的次数
        int []count=new int[26];
        int first=Integer.MAX_VALUE,index=-1;
        //遍历字符串，将每个字符出现的次数记录下来
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)-97]++;
        }
        //将出现一次的数据在字符串中的位置找到并将最小的位置赋值给first
        for(int i=0;i<26;i++){
            if(count[i]==1){
                index=s.indexOf(i+97);
                first=Math.min(first,index);
            }
        }
        return first==Integer.MAX_VALUE ? -1:first;
    }

}
