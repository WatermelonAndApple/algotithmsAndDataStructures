package day07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//划分字母区间
/*
给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。
返回一个表示每个字符串片段的长度的列表。
例如：
输入：s = "ababcbacadefegdehijhklij"
输出：[9,7,8]
解释：
划分结果为 "ababcbaca"、"defegde"、"hijhklij" 。
每个字母最多出现在一个片段中。
像 "ababcbacadefegde", "hijhklij" 这样的划分是错误的，因为划分的片段数较少。
输入：s = "eccbbbbdec"
输出：[10]
 */
public class PartitionLabels {
    public static void main(String[] args) {
        PartitionLabels s =new PartitionLabels();
        System.out.println(s.partitionLabels1("ababcbacadefegdehijhklij"));//[9,7,8]
        System.out.println(s.partitionLabels1("eccbbbbdec"));//[10]
        System.out.println(s.partitionLabels1("eccbbbbdez"));//[9,1]
        System.out.println(s.partitionLabels1("eccbbbbdezxy"));//[9,1,1,1]
        System.out.println(s.partitionLabels1("eccbbbbdeczxyz"));//[10,4]
        System.out.println(s.partitionLabels1("ababcbacadefegdehijhklizxyyx"));//[9,7,7,1,4]
    }
    public List<Integer> partitionLabels1(String s){
        int [] last = new int[26];
        int n = s.length();
        for (int i =0;i<n;i++){//找到每个字母出现的最后的位置
            last[s.charAt(i) - 'a']=i;
        }
        List<Integer> partition = new ArrayList<>();
        int start=0,end=0;
        for (int i =0;i<n;i++){
            end = Math.max(end,last[s.charAt(i)-'a']);
            if(i==end){
                partition.add(end -start +1);
                start = end + 1;
            }
        }
        return partition;
    }

    public List<Integer> partitionLabels(String s) {
        List<Integer> lists = new ArrayList<>();
        int n = s.length();
        if(n == 1){
            lists.add(1);
            return lists;
        }
        HashMap<Character,Integer> preMp = new HashMap<>();//前半部分的哈希表
        HashMap<Character,Integer> nextMp = new HashMap<>();//后半部分的哈希表
        int pre = 0,next = 1 ;//pre表示在前半部分移动的指针，next表示在后半部分移动的指针
        int preTail = 0,tmp;//preTail表示前一段的尾部
        char c;
        while (pre <= next && next < n){
//            System.out.println(pre+";"+next);
            //哈希表赋值
            initHashMap(preMp,s,0,next-1);//前半部分
            initHashMap(nextMp,s,next,n-1);//后半部分
            tmp = isPreMpKeyInNextMp(preMp,nextMp);//
            if(tmp == -1){//后半部分不包含前半部分的字母
                lists.add(preTail - pre +1);
                preTail++;
                pre=preTail;
                next=pre + 1;
            }else {//后半部分包含前半部分的字母
                preTail = tmp;
                next = tmp + 1;
            }//清除哈希表
            preMp.clear();
            nextMp.clear();
        }
        lists.add(n-pre);
        return lists;
    }
    /**
    * description: //给前半部分以及后半部分哈希表赋值
     * @param mp
     * @param s
     * @param start  s中字符的起始位置
     * @param end   s中字符的结束位置
    * return
     **/
    public void initHashMap(HashMap<Character,Integer> mp ,String s,int start,int end){
        char c;
        for(int i = end ; i>=start;i--){
            c=s.charAt(i);
            if(!mp.containsKey(c)){
               mp.put(c,i);
            }
        }
//        System.out.println(start +";"+end);
    }
    //后半部分是否包含前半部分中的字母,（若包含）返回在后半部分最远处的位置
    public int isPreMpKeyInNextMp(HashMap<Character,Integer> preMp,HashMap<Character,Integer> nextMp){
        int index = -1;
        for (Character c:preMp.keySet()){//遍历前半部分
            if(nextMp.containsKey(c)){
                index = Math.max(nextMp.get(c),index);
            }
        }
        return index;//-1表示不包含,大于0表示所在的位置
    }

}
