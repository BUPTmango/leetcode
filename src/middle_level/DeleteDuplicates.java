package middle_level;

import data_structure.linked_list.ListNode;

/**
 * 《玩转算法面试视频例题》链表 创建虚拟头节点
 * 82. 删除排序链表中的重复元素 II
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中没有重复出现的数字。
 * <p>
 * 示例1:
 * <p>
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例2:
 * <p>
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/9/25 9:25 下午
 */
public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy, curr = head;
        while (curr != null && curr.next != null) {
            if (prev.next.val == curr.next.val) {
                // 如果prev、curr指向的节点值相等，就不断移动curr，直到prev、curr指向的值不相等
                while (curr != null && curr.next != null && prev.next.val == curr.next.val) {
                    curr = curr.next;
                }
                prev.next = curr.next;
                curr = curr.next;
            } else {
                prev = prev.next;
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}
