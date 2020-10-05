package middle_level.coder_gold;

import data_structure.linked_list.ListNode;

/**
 * 面试题 02.08. 环路检测
 * 给定一个链表，如果它是有环链表，实现一个算法返回环路的开头节点。
 * 有环链表的定义：在链表中某个节点的next元素指向在它前面出现过的节点，则表明该链表存在环路。
 *
 *
 * 示例 1：
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：tail connects to node index 1
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * 示例 2：
 *
 * 输入：head = [1,2], pos = 0
 * 输出：tail connects to node index 0
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 * 示例 3：
 *
 * 输入：head = [1], pos = -1
 * 输出：no cycle
 * 解释：链表中没有环。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/5 8:37 上午
 */
public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // 此处如果用if (slow != null && fast != null && slow.val == fast.val) 会超出时间限制
            if (slow == fast) {
                break;
            }
        }
        // 若无相会处，则无环路
        if (fast == null || fast.next == null) {
            return null;
        }

        // 若两者以相同的速度移动，则必然在环路起始处相遇
        // slow从head开始，fast从相遇点开始，一步一步走再次相遇即为环入口
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
