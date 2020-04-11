package simple_level.coder_gold;

import data_structure.linked_list.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 面试题 02.06. 回文链表
 * 编写一个函数，检查输入的链表是否是回文的。
 *
 * 示例 1：
 *
 * 输入： 1->2
 * 输出： false
 * 示例 2：
 *
 * 输入： 1->2->2->1
 * 输出： true
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/30 10:18 上午
 */
public class IsPalindrome {
    /**
     * 首先将链表转换成list
     * 之后双指针从两侧向中间靠 检查是否一致
     *
     * 超出时间限制
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        int l = 0;
        int r = list.size() - 1;
        while (l < r) {
            if (!list.get(l).equals(list.get(r))) {
                return false;
            }
            l++;
            l--;
        }
        return true;
    }

    /**
     * 将前半部分放入栈中，之后pop出来和后半段比较
     * 重点是找到中间节点的方法 -- slow走一步 fast走两步
     * @param head
     * @return
     */
    public boolean isPalindrome_stack(ListNode head) {
        ListNode fast = head, slow = head;
        Stack<Integer> stack = new Stack<>();
        while (fast != null && fast.next != null) {
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        int top;
        while (slow != null) {
            top = stack.pop();
            if (top != slow.val) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }
}
