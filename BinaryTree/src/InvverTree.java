public class InvverTree {
    //翻转二叉树
    public static void main(String[] args) {

        //root=[4,2,7,1,3,6,9],result=[4,7,2,9,6,3,1]
//        TreeNode n1=new TreeNode(1);
//        TreeNode n2=new TreeNode(3);
//        TreeNode n3=new TreeNode(6);
//        TreeNode n4=new TreeNode(9);
//        TreeNode n5=new TreeNode(2,n1,n2);
//        TreeNode n6=new TreeNode(7,n3,n4);
//        TreeNode root=new TreeNode(4,n5,n6);
        InverTreeSolution its = new InverTreeSolution();
//        its.preorderTraversal(its.invertTree(root));
//        System.out.println();
//        its.preorderTraversal(its.invertTree(null));
//        //root=[2,1,3],result=[2,3,1]
//        TreeNode n9=new TreeNode(1);
//        TreeNode n8=new TreeNode(3);
//        TreeNode root1=new TreeNode(2,n9,n8);
//        System.out.println();
//        its.preorderTraversal(its.invertTree(root1));
        //root=[1,2,3],targetSum=5
        TreeNode h1=new TreeNode(1);
        TreeNode h2=new TreeNode(3);
        TreeNode t1=new TreeNode(2,h1,h2);
        System.out.println(its.hasPathSum(t1, 5));
        System.out.println(its.hasPathSum(null,0));
        //root=[5,4,8,11,null,13,4,7,2,null,null,null,1],targetSum=22
        TreeNode h3=new TreeNode(2);
        TreeNode t2=new TreeNode(1,h3,null);
        System.out.println(its.hasPathSum(t2,1));
    }
}
class InverTreeSolution{
    //路径总和
//    给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。
//    判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
//    如果存在，返回 true ；否则，返回 false 。
//    叶子节点 是指没有子节点的节点。
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        if(targetSum == root.val&&root.left==null && root.right==null)//找到了,该叶子结点
            return true;
//        System.out.println(hasPathSum(root.left,targetSum-root.val));
//        System.out.println(hasPathSum(root.right,targetSum- root.val));
        return hasPathSum(root.left,targetSum-root.val)||hasPathSum(root.right,targetSum- root.val);
    }
    //翻转二叉树
    public TreeNode invertTree(TreeNode root) {
        if(root==null)
            return root;
        System.out.print(root.val+"\t;");
        if(root.left==null && root.right==null){
            return root;
        }
        invertTree(root.left);//翻转左子树
        invertTree(root.right);//翻转右子树
        TreeNode tmp = root.left;
        root.left=root.right;
        root.right=tmp;
        return root;
    }
    //先序遍历
    public void preorderTraversal(TreeNode root){
        if(root!=null) {
            System.out.print(root.val + "\t");
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
    }
}
