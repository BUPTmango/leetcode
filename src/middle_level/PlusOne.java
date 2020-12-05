package middle_level;

import data_structure.linked_list.ListNode;

/**
 * 快慢指针
 * 369. 给单链表加一
 * 用一个 非空 单链表来表示一个非负整数，然后将这个整数加一。
 *
 * 你可以假设这个整数除了 0 本身，没有任何前导的 0。
 *
 * 这个整数的各个数位按照 高位在链表头部、低位在链表尾部?的顺序排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/12/5 11:24 上午
 */
public class PlusOne {
    /**
     * 快慢指针
     * 1. 用快指针fast，遍历链表
     * 2. fast.val != 9，慢指针移动到当前快指针处
     * 3. fast.val = 9，慢指针原地不动
     * 4. 遍历结束，慢指针的值加一，慢指针后续所有节点值设置为0，打完收工！
     * @param head
     * @return
     */
    public ListNode plusOne(ListNode head) {
        ListNode slow = new ListNode(0);
        slow.next = head;
        ListNode fast = head;
        while (fast != null) {
            if (fast.val != 9) {
                slow = fast;
            }
            fast = fast.next;
        }

        slow.val++;

        // 将之后的9变成0
        ListNode cur = slow.next;
        while (cur != null) {
            cur.val = 0;
            cur = cur.next;
        }
        // 如果是第一位并且是9 就要向前进位返回slow节点也就是dummy节点
        return slow.next == head ? slow : head;
    }
}
