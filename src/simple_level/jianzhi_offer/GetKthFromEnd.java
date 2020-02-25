package simple_level.jianzhi_offer;

import data_structure.linked_list.ListNode;

/**
 * 面试题22. 链表中倒数第k个节点
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 *
 * 返回链表 4->5.
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/2/25 10:37 上午
 */
public class GetKthFromEnd {
    /**
     * 快慢指针
     * 先让快的走k个位置
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head, slow = head;
        while (fast != null) {
            fast = fast.next;
            if (k == 0) {
                slow = slow.next;
            } else {
                k--;
            }
        }
        return slow;
    }
}
