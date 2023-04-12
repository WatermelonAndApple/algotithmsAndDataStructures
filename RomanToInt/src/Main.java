import java.util.HashMap;
import java.util.Map;

public class Main {
    /**
     * 罗马数字转换为整数
     * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
     *
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * @param args
     */
    public static void main(String[] args) {
        Solution s = new Solution();
        /**测试用例1
         * 输入: s = "MCMXCIV"
         * 预期结果: 1994
         * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
         */
        System.out.println(s.romanToInt("MCMXCIV"));

        /**测试用例2
         * 输入: s = "LVIII"
         * 预期结果: 58
         * 解释: L = 50, V= 5, III = 3.
         */
        System.out.println(s.romanToInt("LVIII"));
        //测试
        System.out.println(s.romanToInt("III"));   //预期3
        System.out.println(s.romanToInt("VI"));//预期6
        System.out.println(s.romanToInt("IV"));///预期4
        System.out.println(s.romanToInt("IX"));//预期9


    }
}
class Solution {

    /**
     * 解法1，使用映射的方式实现
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        //        获取罗马字符雨数值的映射
        Map<Character,Integer> romanMap = new HashMap<>();
        romanMap.put('I',1);
        romanMap.put('V',5);
        romanMap.put('X',10);
        romanMap.put('L',50);
        romanMap.put('C',100);
        romanMap.put('D',500);
        romanMap.put('M',1000);
        int result = 0;//结果
        int preVal =0 , nextVal =0;//前一个以及其后的第一个的值
        for(int i=0;i<s.length();i++){
            //如果前一个值比后一个的值要小，则加上后一个减去前一个的值
            preVal = romanMap.get(s.charAt(i));
            if(i+1 < s.length()){//已经到最后一个了
                 nextVal = romanMap.get( s.charAt(i+1));
            }else{
                nextVal = 0;
            }
            if(preVal < nextVal){
                result = result + nextVal - preVal;
                i++;//跳过这两已经运算后的罗马字符
            }else{///如果前一个值比后一个的值要大，则加上前一个的值
                result += preVal;
            }
        }
        return result;
    }
}