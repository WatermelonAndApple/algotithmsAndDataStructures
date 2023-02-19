public class Main {
    //赎金信
    /*
    给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
    如果可以，返回 true ；否则返回 false 。
    magazine 中的每个字符只能在 ransomNote 中使用一次。
     */
    public static void main(String[] args) {
       //测试数据
        String r1="a",m1="b";
        String r2="aa",m2="ab";
        String r3="aa",m3="aab";
        Solution s = new Solution();
        System.out.println(s.canConstruct(r1, m1));
        System.out.println(s.canConstruct(r2, m2));
        System.out.println(s.canConstruct(r3, m3));
    }
}
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        //如果ransomNote字符串比magazine字符串长，则ransomNote必不可能由magazine里面的字符构成
        if(ransomNote.length()>magazine.length())
            return false;
        //用于记录magazine和ransomNote里面的各个字符的出现次数
        int []magazineCharCount=new int[26];
        int []ransomNoteCharCount=new int[26];
        for(int i=0;i<magazine.length();i++){
            magazineCharCount[magazine.charAt(i)-97]++;
        }
        for(int i=0;i<ransomNote.length();i++){
            ransomNoteCharCount[ransomNote.charAt(i)-97]++;
        }
        //判断ransomNote是否可以由magazine中里面的字符构成
        for(int i=0;i<26;i++){
            if(ransomNoteCharCount[i]>magazineCharCount[i]){
                return false;//ransom如果对应的字母的统计次数大于magazine的对应字母的统计次数则不可能构成
            }
        }
        return true;
    }
}