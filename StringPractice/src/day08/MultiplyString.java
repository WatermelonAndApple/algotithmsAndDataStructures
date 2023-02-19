package day08;

public class MultiplyString {
    //字符串相乘
    /*
    给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
    注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
    输入: num1 = "2", num2 = "3"
    输出: "6"
    输入: num1 = "123", num2 = "456"
    输出: "56088"
     */
    public static void main(String[] args) {
        MultiplyString s = new MultiplyString();
        System.out.println(s.multiply("12", "4563"));
//        System.out.println(s.multiply("0", "456"));
        System.out.println(s.multiply("123", "456"));
    }
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
          int m=num1.length(),n=num2.length();
          int []ans = new int[m+n];
          for (int i=m-1;i>=0;i--){
              int x = num1.charAt(i) - '0';
              for (int j=n-1;j>=0;j--){
                  int y=num2.charAt(j) - '0';
                  ans[i+j+1] += x*y;
              }
          }
//          print(ans);
          for (int i = m + n -1;i>0;i--){
              ans[i-1] += ans[i] /10;
              ans[i] %= 10;
          }
//          print(ans);
          int index = ans[0] == 0 ? 1 : 0;
          StringBuffer s = new StringBuffer();
          while (index < m+n){
              s.append(ans[index]);
              index++;
          }
          return s.toString();
    }
    public void print(int [] arr){
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }
}
