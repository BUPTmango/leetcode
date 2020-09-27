package simple_level;

import data_structure.linked_list.ListNode;

/**
 * 《玩转算法面试视频例题》链表
 * 234
 * 回文链表
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * <p>
 * 输入: 1->2->2->1
 * 输出: true
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/2/16 10:59 下午
 */
public class IsPalindrome {
    /**
     * 找到中间节点 分成两个链表
     * 反转第二个链表 两个链表逐一进行比较
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        ListNode newhead = null;
        slow.next = null;
        // 逆置后半段链表
        while (tmp != null) {
            ListNode cur = tmp.next;
            tmp.next = newhead;
            newhead = tmp;
            tmp = cur;
        }
        // 将两段链表进行比较
        while (newhead != null) {
            if (newhead.val != head.val) {
                return false;
            }
            newhead = newhead.next;
            head = head.next;
        }
        return true;
    }

}
