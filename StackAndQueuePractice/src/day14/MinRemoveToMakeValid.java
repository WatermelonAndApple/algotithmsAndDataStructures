package day14;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

//移除无效的括号
public class MinRemoveToMakeValid {
    /*
    给你一个由 '('、')' 和小写字母组成的字符串 s。
    你需要从字符串中删除最少数目的 '(' 或者 ')' （可以删除任意位置的括号)，使得剩下的「括号字符串」有效。
    请返回任意一个合法字符串。
    有效「括号字符串」应当符合以下 任意一条 要求：
    空字符串或只包含小写字母的字符串
    可以被写作 AB（A 连接 B）的字符串，其中 A 和 B 都是有效「括号字符串」
    可以被写作 (A) 的字符串，其中 A 是一个有效的「括号字符串」
    s[i] 可能是 '('、')' 或英文小写字母
     */
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer,Character> map = new HashMap<>();
        Character c;
        for (int i =0; i<s.length();i++){
             c=s.charAt(i);
            if(c == '(' ){//左括弧，记录当前位置
                stack.push(i);
            }else if( c== ')'){
                if(!stack.empty()) {//栈不为空时,将形成的这对括号添加到哈希表中存储
                    map.put(i,')');
                    map.put(stack.pop(),'(');//形成一对括号
                }
            }
        }
        StringBuffer sb = new StringBuffer();
//        再次遍历获取移除后的字符串
        for (int i=0;i<s.length();i++){
            c=s.charAt(i);
            if(c=='(' || c==')'){//为括号时
                if(map.containsKey(i)){//括号为有效括号则将其添加
                    sb.append(c);
                }
            }else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
