package day06;

public class AddStrings {
    //字符串相加
    /*
    给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
    你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式
     */
    public static void main(String[] args) {
        AddStrings s = new AddStrings();
        System.out.println(s.addStrings("0", "0"));
        System.out.println(s.addStrings("11", "123"));
        System.out.println(s.addStrings("456", "77"));
    }
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        StringBuffer ans = new StringBuffer();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            ans.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        // 计算完以后的答案需要翻转过来
        ans.reverse();
        return ans.toString();
    }

}
