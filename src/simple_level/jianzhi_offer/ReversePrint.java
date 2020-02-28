package simple_level.jianzhi_offer;

import data_structure.linked_list.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 面试题06. 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 * ?
 * 限制：
 *
 * 0 <= 链表长度 <= 10000
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/2/28 7:54 上午
 */
public class ReversePrint {
    /**
     * 使用栈
     * Stack
     * @param head
     * @return
     */
    public int[] reversePrint_stack(ListNode head) {
        ListNode iter = head;
        Stack<ListNode> stack = new Stack<>();
        while (iter != null) {
            stack.push(iter);
            iter = iter.next;
        }
        // stack的长度是会改变的，所以提前存好！！！！！
        int size = stack.size();
        int[] result = new int[size];
        for (int j = 0; j < size; j++) {
            result[j] = stack.pop().val;
        }
        return result;
    }

}
