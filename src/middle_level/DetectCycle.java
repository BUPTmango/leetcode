package middle_level;

import data_structure.linked_list.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 142. 环形链表 II
 * 给定一个链表，返回链表开始入环的第一个节点。?如果链表无环，则返回?null。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * 说明：不允许修改给定的链表。
 *
 *
 * 示例 1：
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：tail connects to node index 1
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 *
 * 示例?2：
 *
 * 输入：head = [1,2], pos = 0
 * 输出：tail connects to node index 0
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 *
 * 示例 3：
 *
 * 输入：head = [1], pos = -1
 * 输出：no cycle
 * 解释：链表中没有环。
 *
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/10 9:07 上午
 */
public class DetectCycle {
    /**
     * 快慢指针
     * @param head
     * @return
     */
    public ListNode detectCycle_pointer(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null) {
            // slow走一步 fast走两步
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                // 能走到头 说明没有环
                return null;
            }
            // 找到环之后 从头遍历
            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }

    public ListNode detectCycle_set(ListNode head) {
        ListNode pos = head;
        Set<ListNode> set = new HashSet<>();
        while (pos != null) {
            if (set.contains(pos)) {
                // 出现环
                return pos;
            } else {
                set.add(pos);
            }
            pos = pos.next;
        }
        return null;
    }
}
