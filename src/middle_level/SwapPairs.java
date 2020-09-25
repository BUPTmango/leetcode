package middle_level;

import data_structure.linked_list.ListNode;

/**
 * 《玩转算法面试视频例题》链表 创建虚拟头节点
 * 24. 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/8 11:48 下午
 */
public class SwapPairs {
    /**
     * 递归法(本题为递归法的典型应用)
     * 对于递归法而言，需要关注的最关键三个要素：返回值，调用单元的操作和终止条件。
     * a) 返回值：交换完成后的子链表
     * b) 调用单元：设置需要调换的两个节点为firstNode和secondNode，firstNode用来连接后面交换完成的子链表，secondNode连接firstNode，完成本轮交换操作。
     * c) 终止条件：firstNode或者secondNode为空，对应当前没有节点或者剩下最后一个单独的节点的情况。
     * 迭代法
     * a) 将链表编号分为奇数编号的节点和偶数编号的节点。(要完成的操作是将对应节点两两互换)
     * b) 交换两个节点。
     * c) 维护一个preNode节点，preNode.next指向交换后的头节点。
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        // If the list has no node or has only one node left.
        if ((head == null) || (head.next == null)) {
            return head;
        }

        // Nodes to be swapped
        ListNode firstNode = head;
        ListNode secondNode = head.next;

        // Swapping
        firstNode.next  = swapPairs(secondNode.next);
        secondNode.next = firstNode;

        // Now the head is the second node
        return secondNode;
    }

    public ListNode swapPairs_iterator(ListNode head) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;

        // 当要交换的两个节点存在时进行循环
        while (p.next != null && p.next.next != null) {
            ListNode node1 = p.next;
            ListNode node2 = node1.next;
            ListNode next = node2.next;

            p.next = node2;
            node2.next = node1;
            node1.next = next;

            // 更新p为要交换的前一个节点
            p = node1;
        }

        return dummy.next;
    }
}
