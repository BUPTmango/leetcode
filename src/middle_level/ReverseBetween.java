package middle_level;

import data_structure.linked_list.ListNode;
import util.LinkedListUtil;

/**
 * 反转链表
 * 《玩转算法面试视频例题》 链表
 * 92. 反转链表 II
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * <p>
 * 说明:
 * 1 ≤?m?≤?n?≤ 链表长度。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/6/3 3:24 下午
 */
public class ReverseBetween {

    /**
     * 迭代方法 推荐
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween_better(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // 前驱节点 和 后继节点
        ListNode prev = dummy, successor = null;
        // 反转区间开始节点和结束节点
        ListNode start = head, end = head;

        // 找到前驱节点 和 区间开始节点
        for (int i = 1; i < m; i++) {
            prev = prev.next;
            start = start.next;
            end = end.next;
        }
        // 找到区间结束节点
        for (int i = m; i < n; i++) {
            end = end.next;
        }
        // 找到后继节点
        successor = end.next;

        // 将反转区间的最后一个节点和原链表断开
        end.next = null;
        // 反转后的头节点连在前驱节点后面
        prev.next = reverseList(start);
        // 反转后start变成尾节点，和后继连接起来
        start.next = successor;

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

    /**
     * 头插法
     * author：臣哥
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) {
            return head;
        }
        ListNode tmpHead = new ListNode(-1);
        tmpHead.next = head;
        head = null;
        ListNode p = tmpHead;
        for (int i = 1; i < m; i++) {
            p = p.next;
        }
        ListNode q = p.next;
        ListNode l = q.next, k = null;
        for (int i = 1; i <= n - m; i++) {
            k = l.next;
            l.next = p.next;
            p.next = l;
            l = k;
        }
        q.next = k;
        head = tmpHead.next;
        return head;
    }
}
