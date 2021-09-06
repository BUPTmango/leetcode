package middle_level;

import data_structure.linked_list.ListNode;

import java.util.Stack;

/**
 * ����ת�㷨������Ƶ���⡷����
 * 445. ������� II
 * ���������ǿ����������������Ǹ��������������λλ������ʼλ�á����ǵ�ÿ���ڵ�ֻ�洢�������֡�����������ӻ᷵��һ���µ�����
 * <p>
 * ?
 * <p>
 * ����Լ���������� 0 ֮�⣬���������ֶ��������㿪ͷ��
 * <p>
 * ����:
 * <p>
 * ��������������޸ĸ���δ������仰˵���㲻�ܶ��б��еĽڵ���з�ת��
 * <p>
 * ʾ��:
 * <p>
 * ����: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * ���: 7 -> 8 -> 0 -> 7
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/9 11:50 ����
 */
public class AddTwoNumbers {
    /**
     * ���ܷ�ת�����Խ���ջ��ѹ��ջ�У���ջ��Ԫ�����
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack();
        Stack<Integer> stack2 = new Stack();
        // ��l1����ѹ��ջ
        ListNode node1 = l1;
        while (node1 != null) {
            stack1.push(node1.val);
            node1 = node1.next;
        }
        // ��l2����ѹ��ջ
        ListNode node2 = l2;
        while (node2 != null) {
            stack2.push(node2.val);
            node2 = node2.next;
        }
        ListNode head = null;
        int flag = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty() || flag != 0) {
            int value = 0;
            if (!stack1.isEmpty()) {
                value += stack1.pop();
            }
            if (!stack2.isEmpty()) {
                value += stack2.pop();
            }
            value += flag;
            ListNode node = new ListNode(value % 10);
            flag = value / 10;
            // ��β��ͷ��������
            node.next = head;
            head = node;
        }
        return head;
    }

    public ListNode addTwoNumbers_linked_list(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        ListNode p1 = l1, p2 = l2;
        ListNode dummy = new ListNode(0);
        ListNode pointer = dummy;
        int carry = 0, sum = 0;
        while (p1 != null || p2 != null) {
            int val1 = p1 == null ? 0 : p1.val;
            int val2 = p2 == null ? 0 : p2.val;
            if (p1 != null) {
                p1 = p1.next;
            }
            if (p2 != null) {
                p2 = p2.next;
            }
            sum = val1 + val2 + carry;
            pointer.next = new ListNode(sum % 10);
            pointer = pointer.next;
            carry = sum / 10;
        }
        if (carry != 0) {
            pointer.next = new ListNode(carry);
        }
        return reverseList(dummy.next);
    }

    private ListNode reverseList(ListNode head) {
        ListNode curr = head, prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
