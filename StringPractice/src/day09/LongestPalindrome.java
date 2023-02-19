package day09;

public class LongestPalindrome {
    //最长的回文子串
    /*
    给你一个字符串 s，找到 s 中最长的回文子串。
    如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
    输入：s = "babad"
    输出："bab"
    解释："aba" 同样是符合题意的答案。
    输入：s = "cbbd"
    输出："bb"
     */
    public static void main(String[] args) {
        LongestPalindrome s = new LongestPalindrome();
        s.longestPalindrome("babad");
        s.longestPalindrome("cbbd");
        s.longestPalindrome("abba");
        s.longestPalindrome("aaaaaac");
    }
//    public String longestPalindrome(String s) {
//        if (s == null || s.length() < 1) {
//            return "";
//        }
//        int start = 0, end = 0;
//        for (int i = 0; i < s.length(); i++) {
//            int len1 = expandAroundCenter(s, i, i);
//            int len2 = expandAroundCenter(s, i, i + 1);
//            int len = Math.max(len1, len2);
//            if (len > end - start) {
//                start = i - (len - 1) / 2;
//                end = i + len / 2;
//            }
//        }
//        return s.substring(start, end + 1);
//    }
//
//    public int expandAroundCenter(String s, int left, int right) {
//        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
//            --left;
//            ++right;
//        }
//        return right - left - 1;
//    }
    public String longestPalindrome(String s) {
        int n=s.length(),length = 1;
        int [] longest = new int[n];
        for (int i=0;i<n;i++){
            length = longestInCenter(s,i);
            System.out.print(length+"\t");
            longest[i] = length;//获取以i为中心的最长回文子串的长度
        }
        System.out.println();
        return "";
    }
    //求出以center为中心的最长回文子串的长度
    public int longestInCenter (String s,int center){
        int left = center - 1,right = center + 1, length = 1;
        boolean flag = true;
        char charInCenter,charInLeft,charInRight;//位于center中心位置的字符已经左右两边的字符
        while (left >=0 && right < s.length()){
            charInCenter = s.charAt(center);
            charInLeft = s.charAt(left);
            charInRight = s.charAt(right);
            if(charInLeft == charInRight ){
                length += 2;
                flag=false;
            } else {//如果center左右两边不一致,将center与左边以及右边比较，有一边相等就改变中心位置，将相等的连个字符变为新的中心
                if ( flag && charInCenter == charInRight) {
                    left = center;
                    flag = false;
                } else{
                    break;
                }
                length++;
            }
            left--;
            right++;
        }
        return length;
    }
}
