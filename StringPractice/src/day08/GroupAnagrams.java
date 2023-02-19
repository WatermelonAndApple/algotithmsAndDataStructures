package day08;

import java.util.*;

public class GroupAnagrams {
    /*
    字母异位词分组
    给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
    字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
    输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
    输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
    输入: strs = [""]
    输出: [[""]]
    输入: strs = ["a"]
    输出: [["a"]]
     */
    public static void main(String[] args) {
        String[] t1 = {"eat", "tea", "tatn", "ta", "sds"};
        String[] t2 = {"eat", "tea","tan","ate","nat","bat"};
        String[] t3 = {""};
        String[] t4 = {"a"};
        String[] t5 = {"a", "tea","tan","ate","nasdfat","bat","tab","abcd","abc","cbda","asdfahksdf","b","ab","ba"};
        GroupAnagrams s = new GroupAnagrams();
        System.out.println(s.groupAnagrams1(t1));
        System.out.println(s.groupAnagrams1(t2));
        System.out.println(s.groupAnagrams1(t3));
        System.out.println(s.groupAnagrams1(t4));
        System.out.println(s.groupAnagrams1(t5));
    }
    //哈希表:将每个字符串中相同子母出现的次数已经字符拼接成字符串将其作为哈希表的键值
    public List<List<String>> groupAnagrams1(String[] strs) {
        Map<String,List<String>> mp = new HashMap<>();
        for (String str : strs){
            //统计每个字符串个个字符出现的次数
            int [] count = new int[26];
            int length =str.length();
            for(int i=0;i<length;i++){
                count[str.charAt(i) - 'a']++;
            }
            //将每个字符以及其出现的次数拼接在一起变为字符串
            StringBuffer sb = new StringBuffer();
            for(int i=0;i<26;i++){
                if(count[i] != 0){
                    sb.append( (char) 'a' + i);
                    sb.append(count[i]);
                }
            }
            String key = sb.toString();
            List<String> list = mp.getOrDefault(key,new ArrayList<String>());
            list.add(str);
            mp.put(key,list);
        }
        return new ArrayList<List<String>>(mp.values());
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();//根据字符串的长度从小到大进行排序
            }
        });
        List<List<String>> result = new ArrayList<>();
        int start = 0, end = 0;//长度相等的字符串的首位以及末尾在strs中的下标
        boolean [] isReadyStart ;//用于标记start到end这部分的字符串哪些是已经加入到结果中了，避免重复比较
        while (start < strs.length) {
            end = getEnd(strs, start);//获取end
            isReadyStart = new boolean[end - start + 1];
            for(int i = start; i <= end; i++){
                if (!isReadyStart[i-start]){
                    List<String> l = new ArrayList<>();
                    l.add(strs[i]);
                    for (int j =i+1;j<=end;j++){
                        if (isAnagrams(strs[i],strs[j])){
                            l.add(strs[j]);//找到了同str[i]是异位词的词
                            isReadyStart[j-start]=true;//将标记数组中该位置的值变为true，表示该值已经不需要重复比较了
                        }
                    }
                    result.add(l);
                }
            }
            start=end + 1;
        }
        return result;
    }
    //获取end的位置
    public int getEnd(String[] strs, int start) {
        for (int i = start; i < strs.length; i++) {
            if (strs[i].length() != strs[start].length()) {
                return i - 1;
            }
        }
        return strs.length - 1;
    }

    //s1同s2是否是异位词,s1同s2的长度要一致
    public boolean isAnagrams(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
