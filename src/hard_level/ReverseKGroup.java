package hard_level;

import data_structure.linked_list.ListNode;

/**
 * 反转链表
 * 《玩转算法面试视频例题》链表 创建虚拟头节点
 * 25. K 个一组翻转链表
 * 给你一个链表，每k个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是k的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 示例：
 * <p>
 * 给你这个链表：1->2->3->4->5
 * <p>
 * 当k= 2 时，应当返回: 2->1->4->3->5
 * <p>
 * 当k= 3 时，应当返回: 3->2->1->4->5
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/9/26 9:22 上午
 */
public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // 前序和后继节点
        ListNode prev = dummy, successor = null;
        // 反转区间的端点
        ListNode start = head, end = head;

        while (end != null) {
            // 循环k次，确定待反转区间
            for (int i = 1; i < k && end != null; i++) {
                end = end.next;
            }
            // 如果end节点为空说明不足k个，直接返回
            if (end == null) {
                break;
            }
            // 找到后继节点
            successor = end.next;
            // 重要！！ 将待反转链表的最后一个节点和后续链表断开
            end.next = null;
            // 重新连接反转之后的区间链表
            prev.next = reverseList(start);
            start.next = successor;
            // 对变量进行重新赋值 方便进行下一次循环
            prev = start;
            start = successor;
            end = successor;
        }

        return dummy.next;
    }

    private ListNode reverseList(ListNode head) {
        ListNode cur = head, pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
