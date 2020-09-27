package middle_level;

import data_structure.linked_list.ListNode;

/**
 * 《玩转算法面试视频例题》链表
 * 61. 旋转链表
 * 给定一个链表，旋转链表，将链表每个节点向右移动k个位置，其中k是非负数。
 *
 * 示例1:
 *
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例2:
 *
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步:0->1->2->NULL
 * 向右旋转 4 步:2->0->1->NULL
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/9/27 8:37 下午
 */
public class RotateRight {
    /**
     * 找到旧的尾部并将其与链表头相连 old_tail.next = head，整个链表闭合成环，同时计算出链表的长度 n。
     * 找到新的尾部，第 (n - k % n - 1) 个节点 ，新的链表头是第 (n - k % n) 个节点。
     * 断开环 new_tail.next = None，并返回新的链表头 new_head。
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }

        // 定义尾节点
        ListNode old_tail = head;
        // n为链表长度
        int n;
        for(n = 1; old_tail.next != null; n++) {
            old_tail = old_tail.next;
        }
        // 将链表连成环
        old_tail.next = head;

        // 新链表的尾巴是 n-k-1的位置
        ListNode new_tail = head;
        for (int i = 0; i < n - k % n - 1; i++) {
            new_tail = new_tail.next;
        }
        // 新的头是新的尾巴的next
        ListNode new_head = new_tail.next;

        // 尾巴指向null 打破环
        new_tail.next = null;

        return new_head;
    }
}
