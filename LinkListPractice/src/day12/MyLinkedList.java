package day12;
//设计链表
/*
设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，
next 是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
在链表类中实现这些功能：
get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。
如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 */
public class MyLinkedList {
    Node head;//头结点
    int length ;//链表的长度

    public MyLinkedList() {
        head = new Node();
        length = 0;
    }
    //获取链表中的第index + 1个元素
    public int get(int index) {
        if(index >= length || index < 0){//索引值无效
            return -1;
        }
        Node node = head;
        while (node != null){
            if(index == 0){
                return node.val;
            }
            node = node.next;
            index--;
        }
        return -1;
    }
    //将数据添加到链表的头部
    public void addAtHead(int val) {
        if (length == 0){//只有一个头结点时
            head.val = val;
            length++;//链表长度加一
            return;
        }
        Node newHead = new Node(val , head , null);//新的头结点
        head.prev = newHead;
        head = newHead;
        length++;//链表长度加一
    }
    //将数据添加到链表的尾部
    public void addAtTail(int val) {
        if (length == 0){//只有一个头结点时
            head.val = val;
            length++;//链表长度加一
            return;
        }
        Node node = head;
        while (node.next != null){//一直到尾结点
            node = node.next;
        }
        //将新的尾结点添加到尾部
        Node newTail = new Node(val);
        newTail.next = null;
        newTail.prev = node;
        node.next = newTail;
        length++;//链表长度加一
    }
    //将数据添加到链表的index个结点的前面
    public void addAtIndex(int index, int val) {
        if(index <= 0){//添加到头部
            addAtHead(val);
            return;
        }else if (index == length){//添加到尾部
            addAtTail(val);
            return;
        }else if(index > length){
            return;
        }
        Node pre = head,next;//prev表示是前一个结点，next表示后一个结点
        for (int i=1;i<index;i++){
           pre = pre.next;
        }
        next = pre.next;
        Node newNode = new Node(val,next,pre);
        pre.next = newNode;
        next.prev = newNode;
        length++;//链表长度加一
    }
    //删除链表中的元素
    public void deleteAtIndex(int index) {
        if (index >= length || index < 0){//index无效
            return;
        }
        Node deleteNode = head;//待删除的结点
        for (int i = 0 ; i < index ;i++){
            deleteNode= deleteNode.next;
        }
        Node prev = deleteNode.prev ,next = deleteNode.next;//待删除的结点的前后结点
//        待删除的结点的前后结点连接起来
        if(prev != null){
            prev.next = next;
        }else {
            head = next;
        }
        if(next != null){
            next.prev = prev;
        }
        length--;//链表长度加一
    }
    //打印链表
    public void printMyLinkedList(MyLinkedList l){
        Node node = l.head;
        while (node != null){
            System.out.print(node.val+" , ");
            node = node.next;
        }
        System.out.println();
    }
    //链表的结点
    class Node{//链表结点
        int val;//结点的值
        Node next;//下一个结点
        Node prev;//前一个结点
        Node(){

        }
        Node(int val){
            this.val = val;
        }
        Node(int val,Node next){
            this.val = val;
            this.next = next;
        }
        Node(int val,Node next,Node prev){
            this.next = next;
            this.val = val;
            this.prev = prev;
        }

    }
}
