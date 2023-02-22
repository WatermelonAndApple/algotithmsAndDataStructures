package day14.test;

import day14.MinRemoveToMakeValid;
import org.junit.jupiter.api.Test;

//测试移除无效括号
public class MinRemoveToMakeValidTest {
    @Test
    public void test(){
        MinRemoveToMakeValid m  = new MinRemoveToMakeValid();
        //测试用例1：
//        输入：s = "lee(t(c)o)de)"
//        输出："lee(t(c)o)de"
//        解释："lee(t(co)de)" , "lee(t(c)ode)" 也是一个可行答案。
        System.out.println(m.minRemoveToMakeValid("lee(t(c)o)de)"));
        //测试用例2：
        // 输入：s = "a)b(c)d"
        //输出："ab(c)d"
        System.out.println(m.minRemoveToMakeValid("a)b(c)d"));
        //测试用例3：
        // 输入：s = "))(("
        //输出：""
        //解释：空字符串也是有效的
        System.out.println(m.minRemoveToMakeValid("))(("));
    }
}
