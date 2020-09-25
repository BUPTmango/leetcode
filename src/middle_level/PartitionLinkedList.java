package middle_level;

import data_structure.linked_list.ListNode;
import util.LinkedListUtil;

/**
 * 《玩转算法面试视频例题》链表
 * 86. 分隔链表
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 * ?
 *
 * 示例:
 *
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/9/24 8:25 下午
 */
public class PartitionLinkedList {
    public ListNode partition(ListNode head, int x) {
        // 分别使用两个链表保存小于x和大于x的 之后再连接起来
        if (head == null) {
            return null;
        }
        ListNode low = new ListNode(0);
        ListNode high = new ListNode(0);
        ListNode l_pointer = low, h_pointer = high;
        while (head != null) {
            if (head.val >= x) {
                h_pointer.next = head;
                h_pointer = h_pointer.next;
            } else {
                l_pointer.next = head;
                l_pointer = l_pointer.next;
            }
            head = head.next;
        }
        // 要加上这句话 否则出现循环
        // 要断掉之后的节点 要不会出现循环链表 因为每次添加head节点之后原链表的指针并没有断掉
        h_pointer.next = null;
        l_pointer.next = high.next;
        return low.next;
    }

    public static void main(String[] args) {
        PartitionLinkedList partition = new PartitionLinkedList();
        ListNode head = LinkedListUtil.create(new int[]{1, 4, 3, 2, 5, 2});
        LinkedListUtil.print(head);
        ListNode result = partition.partition(head, 3);
        LinkedListUtil.print(result);
    }
}
