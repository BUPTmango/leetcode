package middle_level;

import data_structure.linked_list.ListNode;

/**
 * 《玩转算法面试视频例题》链表
 * 147. 对链表进行插入排序
 * 对链表进行插入排序。
 *
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 *
 * 插入排序算法：
 *
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 *
 * 示例 1：
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例2：
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/9/26 1:34 下午
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode pre = dummy;
        ListNode cur = head;

        // cur表示要插入的元素
        while (cur != null) {
            // pre是游动指针 指向要插入位置的前一个元素
            pre = dummy;
            while (pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }
            // 保存cur的下一个元素 也就是后面部分链表的头节点
            ListNode next = cur.next;
            // 把原来的断掉 接上新的
            cur.next = pre.next;
            pre.next = cur;
            // 更新下一个要插入的位置
            cur = next;
        }
        return dummy.next;
    }
}
