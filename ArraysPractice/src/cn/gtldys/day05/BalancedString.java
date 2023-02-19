package cn.gtldys.day05;

public class BalancedString {
    //替换子串得到平衡字符串
    /*
    有一个只含有 'Q', 'W', 'E', 'R' 四种字符，且长度为 n 的字符串。
    假如在该字符串中，这四个字符都恰好出现 n/4 次，那么它就是一个「平衡字符串」。
    给你一个这样的字符串 s，请通过「替换一个子串」的方式，使原字符串 s 变成一个「平衡字符串」。
    你可以用和「待替换子串」长度相同的 任何 其他字符串来完成替换。
    请返回待替换子串的最小可能长度。
    如果原字符串自身就是一个平衡字符串，则返回 0。
     */
    public static void main(String[] args) {
        String t1="QWER";
        String t2="QQWE";
        String t3="QQQW";
        String t4="QQQQ";
        String t5="QQQWEERW";//1
        String t6="QQQQEEEW";//3
        String t7="QQEQEQWE";//3
        Solution s = new Solution();
        System.out.println(s.balancedString(t1));  //   预期结果 0
        System.out.println(s.balancedString(t2));  //   1
        System.out.println(s.balancedString(t3));// 2
        System.out.println(s.balancedString(t4));// 3
        System.out.println(s.balancedString(t5));  //   1
        System.out.println(s.balancedString(t6));// 3
        System.out.println(s.balancedString(t7));// 3
        System.out.println(s.balancedString("QQWWQWRQ"));//3
        System.out.println(s.balancedString("WWEQERQWQWWRWWERQWEQ"));//4
    }
}
class Solution {
    public int balancedString(String s) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            cnt[idx(c)]++;
        }

        int partial = s.length() / 4;
        int res = s.length();

        if (check(cnt, partial)) {
            return 0;
        }
        for (int l = 0, r = 0; l < s.length(); l++) {
            while (r < s.length() && !check(cnt, partial)) {
                cnt[idx(s.charAt(r))]--;
                r++;
            }
            if (!check(cnt, partial)) {
                break;
            }
            res = Math.min(res, r - l);
            cnt[idx(s.charAt(l))]++;
        }
        return res;
    }

    public int idx(char c) {
        return c - 'A';
    }

    public boolean check(int[] cnt, int partial) {
        if (cnt[idx('Q')] > partial || cnt[idx('W')] > partial || cnt[idx('E')] > partial || cnt[idx('R')] > partial) {
            return false;
        }
        return true;
    }
//    public int balancedString(String s) {
//        //计数数组
//        int [] count = new int[4];//字符出现的次数,代表QWER分别出现的次数
//        for (int i=0;i<4;i++){
//            count[i] = s.length()/4;
//        }
//        if(isBalanced(count,s)){//s已经是平衡字符串了
//            return 0;
//        }
//        //s需要经过替换字串的方式变为平衡字符串
//        int start=0,end=s.length()-1;//代替换字串在s中的起始以及结束位置
//        return Math.min(getLeftResult(count,s,start,end),getRightResult(count,s,start,end));
//    }
//    private int getLeftResult(int [] count,String s,int start,int end){
//        boolean flag=true;//false表示end--，true表示start++
//        while (start <= end){
//            //先判断统计剩余的字符是否满足字符的个数小于等于n/4
//            if(flag){
//                if(isContinue(count,s,start,end)){
//                    start++;
//                }else{
//                    start--;
//                    flag=false;//start向后移动
//                }
//            }else {
//                if(isContinue(count,s,start,end)){
//                    end--;
//                }else {
//                    end++;
//                    break;
//                }
//            }
//        }
//        if(start>end)
//            return start-end;
//        return end - start + 1;
//    }
//    private int getRightResult(int [] count,String s,int start,int end){
//        boolean flag=true;//false表示start++，true表示end--
//        while (start <= end){
//            //先判断统计剩余的字符是否满足字符的个数小于等于n/4
//            if(flag){
//                if(isContinue(count,s,start,end)){
//                    end--;
//                }else{
//                    end++;
//                    flag=false;//start向后移动
//                }
//            }else {
//                if(isContinue(count,s,start,end)){
//                    start++;
//                }else {
//                    start--;
//                    break;
//                }
//            }
//        }
//        if(start>end)
//            return start-end;
//        return end - start + 1;
//    }
//    //统计剩余的字符是否满足字符的个数小于等于n/4
//    private boolean isContinue(int [] count,String s,int start,int end){
//        for (int i=0;i<4;i++){//初始化计数数据
//            count[i] = 0;
//        }
//       int index = 0,n=s.length();
//       while ((index <= start || index > end) && index < n){
//           if(index==start){
//               index = end+1;
//               continue;
//           }
//           switch (s.charAt(index)){
//               case 'Q':count[0]++;break;
//               case 'W':count[1]++;break;
//               case 'E':count[2]++;break;
//               case 'R':count[3]++;break;
//           }
//           index++;
//       }
////        统计剩余的字符是否满足字符的个数有一个大于n/4
//       if(count[0] > n/4 || count[1] > n/4 || count[2] > n/4 || count[3] > n/4){
//           return false;
//       }
//       return true;
//    }
//    //是否已经是平衡字符串
//    private boolean isBalanced(int [] count,String s){
//        for(int i =0 ;i<s.length();++i){
//            switch (s.charAt(i)){
//                case 'Q':count[0]--;break;
//                case 'W':count[1]--;break;
//                case 'E':count[2]--;break;
//                case 'R':count[3]--;break;
//            }
//        }
//        if(count[0]==0 && count[1]==0 && count[2]==0 && count[3]==0){
//            return true;//是平衡字符串
//        }
//        return false;//不是
//    }

}