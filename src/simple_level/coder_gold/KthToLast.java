package simple_level.coder_gold;

import data_structure.linked_list.ListNode;

/**
 * 面试题 02.02. 返回倒数第 k 个节点
 * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 *
 * 注意：本题相对原题稍作改动
 *
 * 示例：
 *
 * 输入： 1->2->3->4->5 和 k = 2
 * 输出： 4
 * 说明：
 *
 * 给定的 k?保证是有效的。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/16 9:56 上午
 */
public class KthToLast {
    /**
     * 1、先让fast向前走K步；
     * 2、slow和fast同步前进，fast到结尾，slow到目标。
     * @param head
     * @param k
     * @return
     */
    public int kthToLast(ListNode head, int k) {
        ListNode fast = head, slow = head;
        while (fast != null) {
            if (k > 0) {
                fast = fast.next;
                k--;
            } else {
                fast = fast.next;
                slow = slow.next;
            }
        }
        return slow.val;
    }
}
