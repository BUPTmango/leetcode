package simple_level;

import data_structure.linked_list.ListNode;
import data_structure.linked_list.MyLinkedList;
import sun.tools.jstat.Literal;

/**
 * 《玩转算法面试视频例题》链表 创建虚拟头节点
 * 21. 合并两个有序链表
 * 将两个有序链表合并为一个新的有序链表并返回。
 *
 * 新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * @author mango
 * @create 2019-03-07 1:15 PM
 */
public class MergeTwoLists {
    /**
     * 递归
     *
     * 因为是两个排序好的链表，所以，每次ListNode temp都是两者中较小的那个节点。
     * 那么可以理解为已经排好一个了，可以作为返回值。
     * 那么只需要 排序 包涵这个节点的剩余节点的链表以及另外一条链表即可。
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists_recursive(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode node;
        if (l1.val <= l2.val) {
            node = l1;
            node.next = mergeTwoLists_recursive(l1.next, l2);
        } else {
            node = l2;
            node.next = mergeTwoLists_recursive(l1, l2.next);
        }
        return node;
    }

    public ListNode mergeTwoLists_iterator(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        head.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
}