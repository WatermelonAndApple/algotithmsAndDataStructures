import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BFS {
    //二叉树的广度优先搜索
    public static void main(String[] args) {
        TreeNode n1=new TreeNode(9,null,null);
        TreeNode n4=new TreeNode(15,null,null);
        TreeNode n5=new TreeNode(7,null,null);
        TreeNode n2=new TreeNode(20,n4,n5);
        TreeNode root=new TreeNode(3,n1,n2);
        SolutionOfBFS s_bfs=new SolutionOfBFS();
        System.out.println(s_bfs.maxDepth1(root));
    }
}
class SolutionOfBFS {
    //检查二叉树是否为对称二叉树
//    给你一个二叉树的根节点 root ， 检查它是否轴对称。
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root,root);
    }
    public boolean isMirror(TreeNode p,TreeNode q ){
        if(p==null && q == null)
            return true;
        if(p==null || q==null)
            return false;
        return p.val==q.val&&isMirror(p.left,q.right)&&isMirror(p.right,q.left);
    }

    //二叉树的最大深度
//    给定一个二叉树，找出其最大深度。
//    二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        int maxDepth=0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int queueSize = queue.size();
            for(int i=0;i < queueSize;++i){
                TreeNode node = queue.poll();//出队
                if(node.left != null){
                    queue.offer(node.left);//入队当前结点的左子树
                }
                if(node.right != null){//入队当前结点的右子树
                    queue.offer(node.right);
                }
            }
            maxDepth++;
        }
        return maxDepth;
    }
    public int maxDepth1(TreeNode root) {
        //使用递归的方法
        if(root == null)
            return 0;
        int leftMaxDepth = maxDepth1(root.left);
        int rightMaxDepth = maxDepth1(root.right);
        return Math.max(leftMaxDepth,rightMaxDepth)+1;
    }
}

