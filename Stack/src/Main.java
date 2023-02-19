import java.util.Stack;

//使用栈来解决问题
public class Main {
    //有效括号
    /*
    给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
    有效字符串需满足：
    左括号必须用相同类型的右括号闭合。
    左括号必须以正确的顺序闭合。
    每个右括号都有一个对应的相同类型的左括号。
     */
    public static void main(String[] args) {
       String s1="{}";//预期结果true
       String s2="()[]{}";//true
       String s3="(]";//false
        String s4="{[()]}";//true
        String s5="{[({)]}";//false
        Solution sl=new Solution();
        System.out.println(sl.isValid(s1));
        System.out.println(sl.isValid(s2));
        System.out.println(sl.isValid(s3));
        System.out.println(sl.isValid(s4));
        System.out.println(sl.isValid(s5));
        System.out.println(sl.isValid("["));
        System.out.println(sl.isValid("))"));
        System.out.println(sl.isValid("{}}}"));
        System.out.println(sl.isValid("(){}[]]){}"));
    }
}
class Solution {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        char tmp,popChar='\0';
        for(int i=0;i<s.length();i++){
            tmp=s.charAt(i);
            //如果是左括号，则将该元素入栈
            if(tmp=='('||tmp=='{'||tmp=='['){
                st.push(tmp);
            }else {//如果为右括号则出栈
                if(!st.isEmpty())
                    popChar=st.pop();
                else return false;
                if(!(tmp==')'&&popChar=='('||tmp=='}'&&popChar=='{'||tmp==']'&&popChar=='[')){
                    return false;
                }
            }
        }
        if(st.isEmpty()){
            return  true;
        }
        return  false;
    }
}