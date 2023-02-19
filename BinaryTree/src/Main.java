import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    //二叉树的遍历
    public static void main(String[] args) {
//        //root=[1,null,2,3],预期结果:[1,2,3]
//        TreeNode tNode1=new TreeNode(3);
//        TreeNode tNode2=new TreeNode(2,tNode1,null);
//        TreeNode root1=new TreeNode(1,null,tNode2);
//        //root=[],预期结果:[]
//        //root=[1],预期结果:[1]
//        TreeNode root2=new TreeNode(1);
//        //root=[1,2],预期结果：[1,2]
//        TreeNode root3=new TreeNode(1,new TreeNode(2),null);
//        //root=[1,null,2],预期结果：[1,2]
//        TreeNode root4=new TreeNode(1,null,new TreeNode(2));
//        Solution s = new Solution();
//        //前序遍历
//        s.print(s.preorderTraversal(root1));
//        s.print(s.preorderTraversal(null));
//        s.print(s.preorderTraversal(root2));
//        s.print(s.preorderTraversal(root3));
//        s.print(s.preorderTraversal(root4));
//        //中序遍历
//        s.print(s.inorderTraversal(root1));
//        s.print(s.inorderTraversal(null));
//        s.print(s.inorderTraversal(root2));
//        s.print(s.inorderTraversal(root3));
//        s.print(s.inorderTraversal(root4));
//        //后序遍历
//        s.print(s.postorderTraversal(root1));
//        s.print(s.postorderTraversal(null));
//        s.print(s.postorderTraversal(root2));
//        s.print(s.postorderTraversal(root3));
//        s.print(s.postorderTraversal(root4));
    //二叉树的层序遍历
        TreeNode n1=new TreeNode(9,null,null);
        TreeNode n4=new TreeNode(15,null,null);
        TreeNode n5=new TreeNode(7,null,null);
        TreeNode n2=new TreeNode(20,n4,n5);
        TreeNode root=new TreeNode(3,n1,n2);
        Solution s =new Solution();
        System.out.println(s.levelOrder(root));
    }
}
//二叉树数据结构
class TreeNode {
      int val;
      TreeNode left;//左子树
      TreeNode right;//右子树
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}
class Solution {
    List<Integer> list=new ArrayList<>();
    //二叉树的层序遍历:使用队列来保存
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
       if(root == null)
           return list;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);//将二叉树的根结点入队
        while(!queue.isEmpty()){//当队列不等于空时
            List<Integer> l = new ArrayList<Integer>();
            int curSize=queue.size();
            for(int i = 0; i < curSize;i++){
                TreeNode node = queue.poll();//出队
                l.add(node.val);
                System.out.print(node.val);
                //如果者一层的结点有左右子树，则将他们的左右子树入队
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            System.out.println();
            list.add(l);
        }
        return list;
    }
    //二叉树的后序遍历
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root!=null){
            postorderTraversal(root.left);//遍历当前父子树的左子树
//            System.out.print(root.val+"\t");
            postorderTraversal(root.right);//遍历当前父子树的右子树
            list.add(root.val);
        }
        return list;
    }
    //二叉树的中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root!=null){
            inorderTraversal(root.left);//遍历当前父子树的左子树
//            System.out.print(root.val+"\t");
            list.add(root.val);
            inorderTraversal(root.right);//遍历当前父子树的右子树
        }
        return list;
    }
    //二叉树的先序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root!=null){
//            System.out.print(root.val+"\t");
            list.add(root.val);
            preorderTraversal(root.left);//遍历当前父子树的左子树
            preorderTraversal(root.right);//遍历当前父子树的右子树
        }
        return list;
    }
    public void print(List<Integer> list){
//        System.out.println("开始了");
        System.out.println(list);
//        System.out.println("结束了！");
        list.clear();//清空列表
    }
}