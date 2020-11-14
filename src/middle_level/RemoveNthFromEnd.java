package middle_level;

import data_structure.linked_list.ListNode;

/**
 * 快慢指针
 * 《玩转算法面试视频例题》链表 双指针
 * 19. 删除链表的倒数第N个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 *
 * @author Wang Guolong
 * @create 2019-05-07 1:50 PM
 */
public class RemoveNthFromEnd {
    /**
     * 两次遍历 就是找到长度 删除第L - n + 1个节点
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int length = 0;
        ListNode first = head;
        while (first != null) {
            length++;
            first = first.next;
        }
        length -= n;
        first = dummy;
        while (length > 0) {
            length--;
            first = first.next;
        }
        first.next = first.next.next;
        return dummy.next;
    }

    /**
     * 一次遍历 两个指针中间差n个位置 推荐
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd_better(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // second指向dummy节点 first指向要删除的节点的前一个节点 second要移动 n+1 次
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // 同时移动 移动后找到要删除的节点位置为second
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        // 删除节点
        second.next = second.next.next;
        return dummy.next;
    }
}