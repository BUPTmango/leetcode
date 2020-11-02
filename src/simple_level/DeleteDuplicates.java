package simple_level;

import data_structure.linked_list.ListNode;
import util.LinkedListUtil;

/**
 * 双指针 原地修改
 * 《玩转算法面试视频例题》链表
 * 83
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * <p>
 * 示例 1:
 * 输入: 1->1->2
 * 输出: 1->2
 * <p>
 * 示例 2:
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 *
 * @author mango
 * @create 2019-03-17 1:33 PM
 */
public class DeleteDuplicates {
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode p = head;
        //第一个while遍历所有节点
        while (p != null) {
            ListNode q = p.next;
            //第二个while找到下一个不重复的节点
            while (q != null && q.val == p.val) {
                q = q.next;
            }
            //进行连接
            p.next = q;
            //指针指向下一位
            p = p.next;
        }
        return head;
    }

    public ListNode deleteDuplicates_better(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        // 链表的head地址就是链表的地址，返回head即可
        return head;
    }

    /**
     * 快慢指针
     * @param head
     * @return
     */
    public ListNode deleteDuplicates_another(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head, slow = head;
        while (fast != null) {
            if (fast.val != slow.val) {
                // 找到不同 连接
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        // 断开与后面重复元素的连接
        slow.next = null;
        return head;
    }

    public static void main(String[] args) {
        DeleteDuplicates duplicates = new DeleteDuplicates();
        ListNode head = LinkedListUtil.create(new int[]{1, 1, 2, 3, 3});
        LinkedListUtil.print(head);
        ListNode result = duplicates.deleteDuplicates_better(head);
        LinkedListUtil.print(result);
    }
}