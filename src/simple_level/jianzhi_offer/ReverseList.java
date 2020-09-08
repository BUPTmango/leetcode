package simple_level.jianzhi_offer;

import data_structure.linked_list.ListNode;

/**
 * 面试题24. 反转链表
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。?
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL?
 * <p>
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 5000
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/2/27 9:44 上午
 */
public class ReverseList {
    /**
     * 递归方法
     * recursive
     *
     * @param head
     * @return
     */
    public ListNode reverseList_recursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList_recursive(head.next);
        // 反转箭头
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * 迭代方法
     * iterative
     *
     * @param head
     * @return
     */
    public ListNode reverseList_iterative(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    /**
     * 头插法 保存head的下一个节点之后断掉head
     * 相当于旧链表上的节点一个个拆下来插入到新链表上
     * author ： 臣哥
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = head.next;
        head.next = null;
        while (pre != null) {
            ListNode L = pre;
            pre = pre.next;
            L.next = head;
            head = L;
        }
        return head;
    }
}
