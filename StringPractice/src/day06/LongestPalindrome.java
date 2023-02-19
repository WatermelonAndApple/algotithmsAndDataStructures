package day06;

import java.util.HashMap;

public class LongestPalindrome {
    /*
    给定一个包含大写字母和小写字母的字符串 s ，返回 通过这些字母构造成的 最长的回文串 。
    在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。
     */
    public static void main(String[] args) {
        LongestPalindrome s =new LongestPalindrome();
        System.out.println(s.longestPalindrome1("abccccdd"));
        System.out.println(s.longestPalindrome1("a"));
        System.out.println(s.longestPalindrome1("aaaaaccc"));
        System.out.println(s.longestPalindrome1("aacc"));
        System.out.println(s.longestPalindrome1("acb"));
        System.out.println(s.longestPalindrome1("aaccbbbbd"));
    }
    //最长回文串
    public int longestPalindrome(String s) {
        int result = 0 , add = 0;
        //建立哈希表,计算每个字符出现的次数
        HashMap<Character,Integer> mp = new HashMap<>();
        char c;
        for (int i=0;i<s.length();++i) {
            c = s.charAt(i);
            if(mp.containsKey(c)){//,计算加一
                mp.put(c,mp.getOrDefault(c,1)+1);
            }else {//添加map
                mp.put(c,1);
            }
        }
        //遍历哈希表
        for(Integer n : mp.values()){
            if(n > 1 && n % 2 ==0){
                result += n;
            } else if (n > 1 && n % 2 !=0) {
                result += n-1;
                add = 1;
            } else if (n == 1) {
                add = 1;
            }
        }
        System.out.println(mp);
        return result  + add;
    }
    public int longestPalindrome1(String s) {
       int [] count = new int[52];
       int index = 0 , ans=0 , n =s.length();
       for (int i=0; i < n ;++i){
           //小写字母在0-25，大写字母在26-51
           index = s.charAt(i) - 'a' >= 0 ? s.charAt(i) - 'a'  : s.charAt(i) - 'A' + 26;
           count[index]++;
       }
       for(int j=0;j< count.length ; j++){
           if(count[j] > 1){
               ans += count[j] / 2 * 2;
           }
       }
       if(ans < n){
           return ans + 1;
       }
       return ans;
    }

}
