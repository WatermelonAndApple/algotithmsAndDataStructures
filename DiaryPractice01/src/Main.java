/**
 * 给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和
 * 输入:a = "11", b = "1"
 * 输出："100"
 * 输入：a = "1010", b = "1011"
 * 输出："10101"
 * a 和 b 仅由字符 '0' 或 '1' 组成
 * 字符串如果不是 "0" ，就不含前导零
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));
        System.out.println(addBinary("1010", "1011"));
        System.out.println(addBinary("111", "11"));
        System.out.println(addBinary("1111", "1"));
    }
    public static String addBinary(String a, String b) {
        boolean flag = false;//是否进位
        //字符串a和b的长度
        int aLen = a.length() , bLen = b.length();
        int maxLen = Math.max(aLen,bLen) , tmp = 0 ,aIndex , bIndex;
        StringBuffer stringBuffer = new StringBuffer();
        for(int i = 0; i < maxLen; ++i){
            tmp = 0 ;
            aIndex = aLen - 1 -i;
            bIndex = bLen - 1 - i;
            if(aIndex >= 0){
                tmp += a.charAt(aIndex)-48;
            }
            if(bIndex >= 0){
                tmp += b.charAt(bIndex)-48;
            }
            if(flag){
                tmp += 1;
            }
            stringBuffer.append(tmp % 2);
            //判断是否要进位
            flag = tmp >= 2 ? true : false;
        }
        if(flag){
            stringBuffer.append(1);
        }
        return stringBuffer.reverse().toString();
    }
}