package simple_level;

import data_structure.linked_list.ListNode;

/**
 * 《玩转算法面试视频例题》链表
 * 237
 * 删除链表中的节点
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
 *
 * 现有一个链表 --?head =?[4,5,1,9]，它可以表示为:
 * 示例 1:
 *
 * 输入: head = [4,5,1,9], node = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为?5?的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * 示例 2:
 *
 * 输入: head = [4,5,1,9], node = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为?1?的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/2/17 11:45 下午
 */
public class DeleteNode {
    /**
     * 因为参数是一个ListNode 所以没有办法拿到前一个节点
     * 直接将下一个节点的val复制到当前节点之后删除下一个节点就行了
     *
     * 并不是所有的链表问题都是穿针引线 有的特殊情况下可以改变节点的值来达到要求
     * @param node
     */
    public void deleteNode(ListNode node) {
        if (node == null) {
            return;
        }
        if (node.next == null) {
            node = null;
            return;
        }
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
