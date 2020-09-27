package middle_level;

import data_structure.linked_list.ListNode;
import util.LinkedListUtil;

/**
 * 《玩转算法面试视频例题》链表
 * 148. 排序链表
 * 在O(nlogn) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2:
 * <p>
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/9/27 6:40 下午
 */
public class SortList {
    /**
     * 递归操作 top-down 但是不满足题目上的空间要求 空间使用了logn
     * 将链表分成两个链表进行排序之后进行merge操作
     *
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 快指针一次走两步 慢指针一次走一步 快的走完了慢的正好停在中间
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode mid = slow.next;
        // 一个链表分成两个 中间指针断开
        slow.next = null;
        return merge(sortList(head), sortList(mid));
    }


    /**
     * 合并两个有序链表
     *
     * @param l1
     * @param l2
     * @return
     */
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode pointer = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                pointer.next = l2;
                l2 = l2.next;
            } else {
                pointer.next = l1;
                l1 = l1.next;
            }
            pointer = pointer.next;
        }
        if (l1 == null) {
            pointer.next = l2;
        } else {
            pointer.next = l1;
        }
        return dummy.next;
    }


    /**
     * 迭代方法
     *
     * @param head
     * @return
     */
    public ListNode sortList_iterator(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 获取链表长度
        int len = listNodeLength(head);

        // 哨兵节点，也有叫傀儡节点（处理链表问题的一般技巧）
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        // 循环 log n 次    <<1相当于乘以2
        for (int i = 1; i < len; i <<= 1) {
            ListNode prev = dummy;
            ListNode curr = dummy.next;
            // 循环 n 次
            while (curr != null) {
                ListNode left = curr;
                ListNode right = split(left, i);
                curr = split(right, i);
                prev.next = mergeTwoLists(left, right);

                while (prev.next != null) {
                    prev = prev.next;
                }
            }
        }

        return dummy.next;
    }

    /**
     * 根据步长分隔链表
     *
     * @param head
     * @param step
     * @return
     */
    private ListNode split(ListNode head, int step) {
        if (head == null) {
            return null;
        }

        for (int i = 1; head.next != null && i < step; i++) {
            head = head.next;
        }

        ListNode right = head.next;
        // 断掉链表
        head.next = null;
        return right;
    }

    /**
     * 获取链表的长度
     *
     * @param head
     * @return
     */
    private int listNodeLength(ListNode head) {
        int length = 0;
        ListNode curr = head;

        while (curr != null) {
            length++;
            curr = curr.next;
        }

        return length;
    }

    /**
     * 合并两个有序链表
     *
     * @param l1
     * @param l2
     * @return
     */
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }

            curr = curr.next;
        }

        curr.next = l1 != null ? l1 : l2;
        return dummy.next;
    }


    public static void main(String[] args) {
        SortList sl = new SortList();
        ListNode head = LinkedListUtil.create(new int[]{4, 2, 1, 3});
        LinkedListUtil.print(head);
        ListNode result = sl.sortList(head);
        LinkedListUtil.print(result);
    }
}
