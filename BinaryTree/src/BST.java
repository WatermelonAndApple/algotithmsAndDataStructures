import java.util.*;

public class BST {
    //二叉搜索树
    public static void main(String[] args) {
        //root=[4,2,7,1,3],val=2,result=[2,1,3]
//        TreeNode n1=new TreeNode(1);
//        TreeNode n2=new TreeNode(3);
//        TreeNode n3=new TreeNode(2,n1,n2);
//        TreeNode n4=new TreeNode(7);
//        TreeNode root1=new TreeNode(4,n3,n4);
        BSTSoulution bts=new BSTSoulution();
        //二叉搜索树中的搜索
//        bts.preorderTraversal(bts.searchBST1(root1,2));
//        bts.preorderTraversal(bts.searchBST1(root1,5));
        //二叉搜索树中的插入操作
//        bts.preorderTraversal(bts.insertIntoBST(root1,5));
//        System.out.println();
//        bts.preorderTraversal(bts.insertIntoBST(null,5));
//        验证二叉树是否为二叉搜索树
//        TreeNode t1=new TreeNode(1);
//        TreeNode t2=new TreeNode(3);
//        TreeNode t3=new TreeNode(2,t1,t2);
//        System.out.println(bts.isValidBST(t3));
//        TreeNode tt1=new TreeNode(7);
//        TreeNode tt2=new TreeNode(3);
//        TreeNode tt3=new TreeNode(6,tt2,tt1);
//        TreeNode tt4=new TreeNode(4);
//        TreeNode tt5=new TreeNode(5,tt4,tt3);
//        System.out.println(bts.isValidBST(tt5));
        TreeNode n1=new TreeNode(3);
        TreeNode n2= new TreeNode(5);
        TreeNode n3=new TreeNode(0);
        TreeNode n4= new TreeNode(4,n1,n2);
        TreeNode n5= new TreeNode(2,n3,n4);
        TreeNode n6=new TreeNode(7);
        TreeNode n7= new TreeNode(9);
        TreeNode n8=new TreeNode(8,n6,n7);
        TreeNode n9= new TreeNode(6,n5,n8);
//        System.out.println(bts.isRootAncestor(n5, n4));
        System.out.println(bts.lowestCommonAncestor(n9, n5, n4).val);
    }
}
class BSTSoulution{
    //二叉搜索树的公共祖先
    //给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。找到结点p和q的公共祖先
    //一个节点也可以是它自己的祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        //判断p或q是否为祖先
//        if(isRootAncestor(p,q)){//p是q的祖先
//            return p;
//        }
//        if(isRootAncestor(q,p)){//q是p的祖先
//            return q;
//        }
//        如果p，q不是最近的公共祖先,则说明在p和q的之上的最近根结点是最近公共祖先
        Queue<TreeNode> queue=new LinkedList<>();
        Stack<TreeNode> s=new Stack<>();
        //进行层次遍历,找到p和q的最近的公共祖先
        queue.offer(root);
        while (!queue.isEmpty()){
            int size= queue.size();
            for (int i=0;i<size;i++){
                TreeNode node=queue.poll();
                if(isRootAncestor(node,p)&&isRootAncestor(node,q)){
                    s.push(node);
                }
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
        }
        return s.pop();
    }
    //root是否为node的祖先
    public boolean isRootAncestor(TreeNode root, TreeNode node){
        boolean isRootAncestor=false;
        if(root==null)
            return false;
        if(root==node){//root是node的祖先
            return true;
        }
        isRootAncestor=isRootAncestor(root.left,node);
        isRootAncestor= isRootAncestor?isRootAncestor:isRootAncestor(root.right,node);
        return isRootAncestor;
    }
//    两数之和 IV - 输入二叉搜索树
    /*
    给定一个二叉搜索树 root 和一个目标结果 k，如果二叉搜索树中存在两个元素且它们的和等于给定的目标结果，则返回 true。
     */
    public boolean findTarget(TreeNode root, int k) {
        if(root.left==null&&root.right==null)
            return false;
       HashSet<Integer> hs = new HashSet<>();
       Queue<TreeNode> queue=new LinkedList<>();
       queue.offer(root);
       while (!queue.isEmpty()){
           int size=queue.size();
           for(int i=0;i<size;i++){
               TreeNode node=queue.poll();
               hs.add(node.val);
               if(k- node.val!= node.val&&hs.contains(k- node.val)){
                   return true;
               }
               if(node.left!=null){
                   queue.offer(node.left);
               }
               if(node.right!=null){
                   queue.offer(node.right);
               }
           }
       }
       return false;
    }

    //验证二叉搜索树
    /*
    给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
    有效 二叉搜索树定义如下：
    节点的左子树只包含 小于 当前节点的数。
    节点的右子树只包含 大于 当前节点的数。
    所有左子树和右子树自身必须也是二叉搜索树。
     */
    public boolean isValidBST(TreeNode root) {
        return childTreeisValidBST(root, Long.MIN_VALUE,Long.MAX_VALUE);
    }
    //验证子树是否为二叉搜索树
    public boolean childTreeisValidBST(TreeNode node,long lower,long upper){
            if(node == null)
                return true;
            if(node.val<=lower || node.val >= upper)
                return false;
            return childTreeisValidBST(node.left,lower,node.val)&&childTreeisValidBST(node.right, node.val, upper);
    }

//    二叉搜索树中的插入操作
//    给定二叉搜索树（BST）的根节点 root 和要插入树中的值 value ，将值插入二叉搜索树。
//    返回插入后二叉搜索树的根节点。 输入数据 保证 ，新值和原始二叉搜索树中的任意节点值都不同。
//    注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回 任意有效的结果
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode curNode = root;
        while (curNode!=null){
            if(curNode.val < val){//如果当前结点的值小于val,将结点与当前结点的右子树进行比较
                if(curNode.right==null){
                    curNode.right=new TreeNode(val);
                    break;//执行插入操作
                }else {
                    curNode = curNode.right;
                }
            }
            if(curNode.val > val){//如果当前结点的值大于val,将结点与当前结点的左子树进行比较
                if(curNode.left==null){
                    curNode.left=new TreeNode(val);
                    break;//执行插入操作
                }else {
                    curNode = curNode.left;
                }
            }
        }
        if(root == null){
            root = new TreeNode(5);
        }
        return root;
    }
    //二叉搜索树中的搜索
//    给定二叉搜索树（BST）的根节点 root 和一个整数值 val。
//    你需要在 BST 中找到节点值等于 val 的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 null 。
    //方法1：递归
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null)
            return null;
        if(root.val==val)//如果找到则返回该结点
            return root;
       TreeNode node=searchBST(root.left,val);//如果node不等于null，则返回node
       node = node==null ? searchBST(root.right,val) : node;
       return node;
    }
    //方法2：迭代
    public TreeNode searchBST1(TreeNode root, int val) {
        while (root!=null){
            if(val==root.val)
                return root;
            root = val < root.val ? root.left : root.right;
        }
        return null;
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
