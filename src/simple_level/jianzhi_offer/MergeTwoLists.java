package simple_level.jianzhi_offer;

import data_structure.linked_list.ListNode;

import java.util.List;

/**
 * 面试题25. 合并两个排序的链表
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * 示例1：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 限制：
 *
 * 0 <= 链表长度 <= 1000
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/2/28 10:12 上午
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode pointer1 = l1;
        ListNode pointer2 = l2;
        ListNode current = new ListNode(0);
        ListNode dummy = current;
        while (pointer1 != null && pointer2 != null) {
            if (pointer1.val < pointer2.val) {
                current.next = pointer1;
                pointer1 = pointer1.next;
            } else {
                current.next = pointer2;
                pointer2 = pointer2.next;
            }
            current = current.next;
        }
        if (pointer1 == null && pointer2 != null) {
            current.next = pointer2;
        }
        if (pointer1 != null && pointer2 == null) {
            current.next = pointer1;
        }
        return dummy.next;
    }
}
