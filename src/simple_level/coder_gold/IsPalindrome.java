package simple_level.coder_gold;

import data_structure.linked_list.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * ������ 02.06. ��������
 * ��дһ���������������������Ƿ��ǻ��ĵġ�
 *
 * ʾ�� 1��
 *
 * ���룺 1->2
 * ����� false
 * ʾ�� 2��
 *
 * ���룺 1->2->2->1
 * ����� true
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/30 10:18 ����
 */
public class IsPalindrome {
    /**
     * ���Ƚ�����ת����list
     * ֮��˫ָ����������м俿 ����Ƿ�һ��
     *
     * ����ʱ������
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
     * ��ǰ�벿�ַ���ջ�У�֮��pop�����ͺ��αȽ�
     * �ص����ҵ��м�ڵ�ķ��� -- slow��һ�� fast������
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
