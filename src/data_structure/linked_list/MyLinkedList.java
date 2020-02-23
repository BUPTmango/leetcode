package data_structure.linked_list;

/**
 * 自定义链表基本操作
 * <p>
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 *
 * @author mango
 * @create 2019-02-28 1:54 PM
 */
public class MyLinkedList {

    private int size;           //链表大小
    private ListNode head;      //链表头部指针

    public ListNode getHead() {
        return head;
    }

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        this.size = 0;
        this.head = null;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        //如果index超出范围 返回-1
        if (index > size - 1 || index < 0) {
            return -1;
        }
        int count = 0;
        ListNode target = head;
        while (index > count) {
            target = target.next;
            count++;
        }
        return target.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        ListNode node = new ListNode(val);
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        ListNode addNode = new ListNode(val);
        //如果index超出范围 返回
        if (index > size || index < 0) {
            return;
        }
        if (index == 0) {
            addNode.next = head;
            head = addNode;
            size++;
            return;
        }
        int count = 1;
        ListNode node = head;
        while (index > count) {
            node = node.next;
            count++;
        }
        //在node之后插入节点
        addNode.next = node.next;
        node.next = addNode;
        size++;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        //如果index超出范围 返回
        if (index > size - 1 || index < 0) {
            return;
        }
        if (index == 0) {
            if (size > 0) {
                //删除头节点
                head = head.next;
                size--;
                return;
            } else {
                return;
            }
        }
        int count = 1;
        ListNode node = head;
        while (index > count) {
            node = node.next;
            count++;
        }
        //删除node的下一节点
        node.next = node.next.next;
        size--;
    }
    public void printList() {
        ListNode node = head;
        while (node != null) {
            System.out.print(node.val);
            node = node.next;
            if (node != null) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }
    public static void printList(ListNode head) {
        ListNode node = head;
        while (node != null) {
            System.out.print(node.val);
            node = node.next;
            if (node != null) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }


    public static void main(String[] args) {
        MyLinkedList obj = new MyLinkedList();
        obj.printList();
        obj.addAtHead(1);
        obj.addAtHead(10);
        obj.addAtTail(5);
        obj.addAtIndex(10,100);
//        obj.deleteAtIndex(4);
        obj.printList();
    }
}