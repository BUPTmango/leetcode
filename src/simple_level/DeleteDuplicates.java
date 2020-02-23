package simple_level;

import data_structure.linked_list.ListNode;
import data_structure.linked_list.MyLinkedList;

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 * 输入: 1->1->2
 * 输出: 1->2
 *
 * 示例 2:
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 *
 * @author mango
 * @create 2019-03-17 1:33 PM
 */
public class DeleteDuplicates {
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode p = head;
        //第一个while遍历所有节点
        while (p != null) {
            ListNode q = p.next;
            //第二个while找到下一个不重复的节点
            while (q != null && q.val == p.val) {
                q = q.next;
            }
            //进行连接
            p.next = q;
            //指针指向下一位
            p = p.next;
        }
        return head;
    }

    public static void main(String[] args) {
        MyLinkedList my = new MyLinkedList();
        my.addAtTail(1);
        my.addAtTail(1);
        my.addAtTail(2);
        my.addAtTail(3);
        my.addAtTail(3);
        MyLinkedList.printList(deleteDuplicates(my.getHead()));
    }
}