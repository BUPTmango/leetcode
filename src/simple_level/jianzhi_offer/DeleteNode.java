package simple_level.jianzhi_offer;

import data_structure.linked_list.ListNode;

/**
 * 面试题18. 删除链表的节点
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 *
 * 返回删除后的链表的头节点。
 *
 * 注意：此题对比原题有改动
 *
 * 示例 1:
 *
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为?5?的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * 示例 2:
 *
 * 输入: head = [4,5,1,9], val = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为?1?的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 * ?
 *
 * 说明：
 *
 * 题目保证链表中节点的值互不相同
 * 若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/6 8:37 上午
 */
public class DeleteNode {
    public ListNode deleteNode(ListNode head, int val) {
        // 如果删除的是头节点 直接返回头节点的下一个节点
        if (head.val == val) {
            return head.next;
        }
        ListNode dummy = new ListNode(0);
        // 定义dummy的下一节点是head 接下来对dummy后面的链表进行处理 最后返回dummy.next
        dummy.next = head;
        while (head != null && head.next != null) {
            if (head.next.val == val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return dummy.next;
    }
}
