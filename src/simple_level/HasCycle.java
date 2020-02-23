package simple_level;

import data_structure.linked_list.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 141
 * 给定一个链表，判断链表中是否有环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。
 *
 * 示例 1：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * 示例 2：
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 * 示例 3：
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 *
 * @author mango
 * @create 2019-03-26 9:39 AM
 */
public class HasCycle {
    /**
     * 遍历链表把所有的节点放入set中
     *      若set中包含当前节点，则含有环
     *      若set中没有，则把节点放入set
     *      取下一个节点
     * 若节点为null，则遍历结束，肯定没有环。
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        Set<ListNode> integerSet = new HashSet<>();
        while (head != null) {
            if (integerSet.contains(head)) {
                return true;
            } else {
                integerSet.add(head);
            }
            head = head.next;
        }
        return false;
    }
}