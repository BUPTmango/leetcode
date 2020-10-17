package middle_level.coder_gold;

import data_structure.linked_list.ListNode;

/**
 * 面试题 02.04. 分割链表
 * 编写程序以 x 为基准分割链表，使得所有小于 x 的节点排在大于或等于 x 的节点之前。如果链表中包含 x，x 只需出现在小于 x 的元素之后(如下所示)。分割元素 x 只需处于“右半部分”即可，其不需要被置于左右两部分之间。
 *
 * 示例:
 *
 * 输入: head = 3->5->8->5->10->2->1, x = 5
 * 输出: 3->1->2->10->5->5->8
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/17 9:28 上午
 */
public class Partition {
    public ListNode partition(ListNode head, int x) {
        ListNode p = head;
        ListNode q = head;
        // q为遍历指针
        while (q != null) {
            if (q.val < x) {
                // p和q交换val
                int middle = p.val;
                p.val = q.val;
                q.val = middle;
                p = p.next;
            }
            q = q.next;
        }
        return head;
    }
}
