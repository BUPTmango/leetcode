package simple_level.coder_gold;

import data_structure.linked_list.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 面试题 02.01. 移除重复节点
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 *
 * 示例1:
 *
 *  输入：[1, 2, 3, 3, 2, 1]
 *  输出：[1, 2, 3]
 * 示例2:
 *
 *  输入：[1, 1, 1, 1, 2]
 *  输出：[1, 2]
 * 提示：
 *
 * 链表长度在[0, 20000]范围内。
 * 链表元素在[0, 20000]范围内。
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/20 9:23 上午
 */
public class RemoveDuplicateNodes {
    public ListNode removeDuplicateNodes(ListNode head) {
        Set<Integer> set = new HashSet<>();
        ListNode prev = new ListNode(0);
        ListNode current = head;
        prev.next = head;
        while (current != null) {
            if (set.contains(current.val)) {
                prev.next = current.next;
            } else {
                set.add(current.val);
                prev = current;
            }
            current = current.next;
        }
        return head;
    }
}
