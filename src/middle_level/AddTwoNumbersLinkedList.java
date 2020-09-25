package middle_level;

import data_structure.linked_list.ListNode;

/**
 * ����ת�㷨������Ƶ���⡷����
 * 2. �������
 * ���������ǿ� ������������ʾ�����Ǹ������������У����Ǹ��Ե�λ���ǰ�������ķ�ʽ�洢�ģ��������ǵ�ÿ���ڵ�ֻ�ܴ洢һλ���֡�
 *
 * ��������ǽ��������������������᷵��һ���µ���������ʾ���ǵĺ͡�
 *
 * �����Լ���������� 0 ֮�⣬���������������� 0��ͷ��
 *
 * ʾ����
 *
 * ���룺(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * �����7 -> 0 -> 8
 * ԭ��342 + 465 = 807
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/9/25 10:05 ����
 */
public class AddTwoNumbersLinkedList {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}
