package simple_level;

import data_structure.linked_list.ListNode;

/**
 * 《玩转算法面试视频例题》链表 创建虚拟头节点
 * 203. 移除链表元素
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/8/12 5:48 下午
 */
public class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        // 创建哨兵节点
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;

        ListNode prev = sentinel, curr = head;
        while (curr != null) {
            if (curr.val == val) {
                // 相同 挪两位
                prev.next = curr.next;
            } else {
                // 不同 挪一位
                prev = curr;
            }
            curr = curr.next;
        }
        return sentinel.next;
    }
}
