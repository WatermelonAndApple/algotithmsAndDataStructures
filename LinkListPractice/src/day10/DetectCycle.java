package day10;

import main.ListNode;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//环形链表
public class DetectCycle {
    /*
    给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
    如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，
    评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。
    注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
    不允许修改 链表。
    输入：head = [3,2,0,-4], pos = 1
    输出：返回索引为 1 的链表节点
    解释：链表中有一个环，其尾部连接到第二个节点。
    输入：head = [1,2], pos = 0
    输出：返回索引为 0 的链表节点
    解释：链表中有一个环，其尾部连接到第一个节点。
    输入：head = [1], pos = -1
    输出：返回 null
    解释：链表中没有环。
     */
    //使用哈希表的方式
    public ListNode detectCycle(ListNode head) {
        //如果链表结点数为小于2，则不可能存在环
        if (head == null || head.next == null) {
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        while (head.next != null) {
            if (set.contains(head)) {//如果存在head了则说明此时回到了环形链表的链表开始入环的第一个节点
                System.out.println(head);
                return head;
            }
            set.add(head);
            head = head.next;
        }
        //不存在环形链表
        return null;
    }

    //使用双指针的方式,快慢指针，快指针，慢指针
    public ListNode detectCycle1(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head, slow = head;
        while (fast != null) {
            slow = slow.next;//慢指针每次往前移动一位
            if (fast.next != null) {
                fast = fast.next.next;//快指针每次往前移动两位
            } else {
                return null;
            }
            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                System.out.println(ptr);
                return ptr;
            }
        }
        return null;
    }
}
