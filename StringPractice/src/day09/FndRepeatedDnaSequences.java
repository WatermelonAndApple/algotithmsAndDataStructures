package day09;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FndRepeatedDnaSequences {
    //重复的DNA序列
    /*
    DNA序列 由一系列核苷酸组成，缩写为 'A', 'C', 'G' 和 'T'.。
    例如，"ACGAATTCCG" 是一个 DNA序列 。
    在研究 DNA 时，识别 DNA 中的重复序列非常有用。
    给定一个表示 DNA序列 的字符串 s ，返回所有在 DNA 分子中出现不止一次的 长度为 10 的序列(子字符串)。你可以按 任意顺序 返回答案
     */
    public static void main(String[] args) {
        String t1 = "AAAAAAAAAAAAA";
        String t2 = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        FndRepeatedDnaSequences s = new FndRepeatedDnaSequences();
        System.out.println(s.findRepeatedDnaSequences(t1));
        System.out.println(s.findRepeatedDnaSequences(t2));
        System.out.println(s.findRepeatedDnaSequences("AAAAAAAAAAA"));
    }
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        int n = s.length();
        if( n <= 10){
            return result;
        }
       Map<String,Integer> map =new HashMap<String,Integer>();
        for(int i=0;i<=n-10;i++){
            String sub = s.substring(i,i+10);//获取字串
            int count = map.getOrDefault(sub,0) + 1;
            if(count == 2){//出现两次
                result.add(sub);
            }
//            System.out.println(sub);
            map.put(sub,count);
        }
//        System.out.println(map);
        return result;
    }
}
