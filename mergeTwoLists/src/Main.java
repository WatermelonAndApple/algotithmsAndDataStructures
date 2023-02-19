public class Main {
    //合并两个有序链表
    /*
    将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     */
    public static void main(String[] args) {
        //两个有递增序链表l1=[1,2,4],l2=[1,3,4]
        //测试用例1
        ListNode l1_n2=new ListNode(4);
        ListNode l1_n1=new ListNode(2,l1_n2);
        ListNode l1=new ListNode(1,l1_n1);
        ListNode l2_n2=new ListNode(4);
        ListNode l2_n1=new ListNode(3,l2_n2);
        ListNode l2=new ListNode(1,l2_n1);
        //测试用例2:  l3=[]  ,  l4=[]
        ListNode l3=new ListNode();
        ListNode l4=new ListNode();
        //测试用例3： l5=[] , l6=[0]
        ListNode l5=new ListNode();
        ListNode l6=new ListNode(0);
        Solution s =new Solution();
        s.printList(s.mergeTwoLists(l1,l2));
        System.out.println();
        s.printList(s.mergeTwoLists(null,null));
        System.out.println();
        s.printList(s.mergeTwoLists(null,l6));
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    //将list1和list2这两个有序链表合并为一个新的有序链表
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode mergeList=new ListNode();
        ListNode curNode=mergeList;
        while (list1!=null||list2!=null){
            //如果list1或者list2等于null了，则说明将剩下的结点直接拼接到当前的合并链表后就可以了。
            if(list1==null){
                curNode.next=list2;
                break;
            }else if(list2==null){
                curNode.next=list1;
                break;
            }
            if(list1.val<=list2.val){
               curNode.next=list1;
                list1=list1.next;
                curNode=curNode.next;
            }else{
                curNode.next=list2;
                list2=list2.next;
                curNode=curNode.next;
            }
        }
        return mergeList.next;
    }
    public void printList(ListNode list){
        while (list!=null){
            System.out.print(list.val+"\t");
            list=list.next;
        }
    }

}