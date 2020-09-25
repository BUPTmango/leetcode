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
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode a = dummy;
        ListNode b = head;
        while (b != null && b.next != null) {
            // 初始化的时a指向的是哑结点，所以比较逻辑应该是a的下一个节点和b的下一个节点
            if (a.next.val != b.next.val) {
                a = a.next;
                b = b.next;
            } else {
                // 如果a、b指向的节点值相等，就不断移动b，直到a、b指向的值不相等
                while (b != null && b.next != null && a.next.val == b.next.val) {
                    b = b.next;
                }
                a.next = b.next;
                b = b.next;
            }
        }
        return dummy.next;
    }
}
