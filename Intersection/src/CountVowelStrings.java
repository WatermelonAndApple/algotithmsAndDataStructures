/**
 * 给你一个整数 n，请返回长度为 n 、仅由元音 (a, e, i, o, u) 组成且按 字典序排列 的字符串数量。
 *
 * 字符串 s 按 字典序排列 需要满足：对于所有有效的 i，s[i] 在字母表中的位置总是与 s[i+1] 相同或在 s[i+1] 之前。
 *
 * 输入：n = 1
 * 输出：5
 * 解释：仅由元音组成的 5 个字典序字符串为 ["a","e","i","o","u"]
 * 输入：n = 2
 * 输出：15
 * 解释：仅由元音组成的 15 个字典序字符串为
 * ["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"]
 * 注意，"ea" 不是符合题意的字符串，因为 'e' 在字母表中的位置比 'a' 靠后
 */
public class CountVowelStrings {
    public static void main(String[] args) {
        System.out.println(countVowelStrings(1));
        System.out.println(countVowelStrings(2));
        System.out.println(countVowelStrings(3));
        System.out.println(countVowelStrings(33));
    }
    public static int countVowelStrings(int n) {
        if(n == 1){
            return 5;
        }
        int [] tmp = {1,1,1,1,1};
        int count = 0;
        for(int i =1 ; i < n;i++){
            count = 1;
            for(int j =1;j<5;j++){
                tmp[j] = tmp[j-1] + tmp[j];
                count+=tmp[j];
            }
        }
        return count;
    }
}
