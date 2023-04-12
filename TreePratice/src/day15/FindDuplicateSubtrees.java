package day15;


import utils.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 寻找重复的子树
 * 给你一棵二叉树的根节点 root ，返回所有 重复的子树 。
 * 对于同一类的重复子树，你只需要返回其中任意 一棵 的根结点即可。
 * 如果两棵树具有 相同的结构 和 相同的结点值 ，则认为二者是 重复 的。
 *
 */
public class FindDuplicateSubtrees {

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(11);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(1,n1,null);
        TreeNode n4 = new TreeNode(11,n2,null);
        TreeNode root = new TreeNode(2,n3,n4);
        Solution s = new Solution();
        for (TreeNode duplicateSubtree : s.findDuplicateSubtrees(root)) {
            System.out.println(duplicateSubtree.val);
        }
    }
}
class Solution{
    StringBuffer stringBuffer;
    Map<String,TreeNode> map,resultMap;

    public Solution() {
        this.stringBuffer = new StringBuffer();
        this.map = new HashMap<>();
        this.resultMap = new HashMap<>();
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        preorder(root);
        List<TreeNode> list = new ArrayList<>();
        for (TreeNode value : resultMap.values()) {
            list.add(value);
        }
        return list;
    }
    /**
     * 先序遍历二叉树获取遍历的序列字符串
     * @param root
     */
    public void preorderStr(TreeNode root){
        if(root == null){
            stringBuffer.append("-");
            return;
        }
        //获取遍历后的字符串
        stringBuffer.append("_"+root.val);
        preorderStr(root.left);
        preorderStr(root.right);
    }
    public void preorder(TreeNode root){
        if(root == null){
            return;
        }
        preorderStr(root);//获取以当前结点为根结点遍历后的序列字符串
        //以当前结点为根结点遍历后的序列字符串作为map的键，当前的结点作为值
        String str = stringBuffer.toString();
        if(map.containsKey(str))
            resultMap.put(str,root);
        else
             map.put(str,root);
        //清空StringBuffer
        stringBuffer.delete(0,stringBuffer.length());
        preorder(root.left);
        preorder(root.right);
    }
}
