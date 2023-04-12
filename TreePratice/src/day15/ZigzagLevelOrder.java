package day15;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 二叉树的锯齿形层序遍历
public class ZigzagLevelOrder {
    public static void main(String[] args) {
        ZigzagLevelOrder s = new ZigzagLevelOrder();
        TreeNode t4= new TreeNode(15);
        TreeNode t5= new TreeNode(7);
        TreeNode t2= new TreeNode(20,t4,t5);
        TreeNode t3= new TreeNode(9);
        TreeNode t1= new TreeNode(1,t3,t2);
        System.out.println(s.zigzagLevelOrder(t1));
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        List <TreeNode> treeNodeList = new ArrayList<>();
        treeNodeList.add(root);
        int n = 0 , size = treeNodeList.size();//n层数,
//        stack.push(root);//将根结点添加到栈中
        while (size > 0){
            if(!stack.empty()){//如果栈不为空,全部出栈
                List <Integer> l = new ArrayList<>();
                while (!stack.empty()){//全部出栈
                    TreeNode node = stack.pop();
                    l.add(node.val);
                    if(n % 2 == 0){//从左向右
                        if (node.left != null){
                            treeNodeList.add(node.left);
                        }
                        if(node.right != null){
                            treeNodeList.add(node.right);
                        }
                    } else if (n % 2 == 1) {//从有向左
                        if(node.right != null){
                            treeNodeList.add(node.right);
                        }
                        if (node.left != null){
                            treeNodeList.add(node.left);
                        }
                    }
                }
                result.add(l);
                n++;
            }else {//将上一层出栈的结点的下一层结点入栈,
                size = treeNodeList.size();
                for (int i=0;i<size;i++){
                    stack.push(treeNodeList.get(i));
                }
                treeNodeList.clear();
            }
        }
        return result;
    }
}
