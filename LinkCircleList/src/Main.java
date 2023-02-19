import java.util.HashSet;

public class Main {
    //环形链表
    /*
    给你一个链表的头节点 head ，判断链表中是否有环。
    如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
    为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
    注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
    如果链表中存在环 ，则返回 true 。 否则，返回 false 。
     */
    public static void main(String[] args) {
        ListNode head1=new ListNode(3);
        ListNode n1=new ListNode(2);
        ListNode n2=new ListNode(0);
        ListNode n3=new ListNode(-4);
        head1.next=n1;
        n1.next=n2;
        n2.next=n3;
        n3.next=n1;

        ListNode head2=new ListNode(1);
        ListNode hn1=new ListNode(2);
        head2.next=hn1;
        hn1.next=head2;

        ListNode head3=new ListNode(1);
        Solution s =new Solution();
        System.out.println(s.hasCycle1(head1));
        System.out.println(s.hasCycle1(head2));
        System.out.println(s.hasCycle1(head3));
    }
}
class ListNode {
      int val;
     ListNode next;
      ListNode(int x) {
          val = x;
         next = null;
    }
 }
 class Solution {
    //通过哈希表
    public boolean hasCycle(ListNode head) {
        ListNode next=null;
        if(head!=null) {
            next = head;
        }else{
            return false;
        }
        HashSet<ListNode> hs =new HashSet<>();
        //往下追踪next
        while (next.next!=null){
            if(!hs.add(next)){
                return true;
            }
            next=next.next;
        }
        return false;
    }
    //通过快慢指针的形式,块指针每次行动两格，慢指针每次行动1格
     //快指针初始时等于head，慢指针初始时等于head.next
    public boolean hasCycle1(ListNode head){
        if(head==null||head.next==null)
            return false;
        //快慢指针
        ListNode fastPoint=head.next;
        ListNode slowPoint=head;
        while (slowPoint!=fastPoint){
            if(fastPoint==null || fastPoint.next==null){
                return  false;
            }
            slowPoint=slowPoint.next;
            fastPoint=fastPoint.next.next;
        }
        return true;
    }

}