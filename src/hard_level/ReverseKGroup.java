package hard_level;

import data_structure.linked_list.ListNode;

/**
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
        ListNode pre = dummy;

        while (head != null) {
            ListNode tail = pre;
            // 查看剩余部分长度是否大于等于 k
            for (int i = 0; i < k; ++i) {
                tail = tail.next;
                // 剩余部分链表长度不足k 直接返回 无需再反转
                if (tail == null) {
                    return dummy.next;
                }
            }
            ListNode nex = tail.next;
            // 反转head到tail的链表
            ListNode[] reverse = myReverse(head, tail);
            head = reverse[0];
            tail = reverse[1];
            // 把子链表重新接回原链表
            pre.next = head;
            tail.next = nex;
            // 更新下一步需要连接的位置
            pre = tail;
            head = nex;
        }

        return dummy.next;
    }

    public ListNode[] myReverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode p = head;
        while (prev != tail) {
            ListNode nex = p.next;
            p.next = prev;
            // 更新位置
            prev = p;
            p = nex;
        }
        return new ListNode[]{tail, head};
    }
}
