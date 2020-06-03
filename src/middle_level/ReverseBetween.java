package middle_level;

import data_structure.linked_list.ListNode;

/**
 * 92. ��ת���� II
 * ��ת��λ�� m �� n ��������ʹ��һ��ɨ����ɷ�ת��
 *
 * ˵��:
 * 1 ��?m?��?n?�� �����ȡ�
 *
 * ʾ��:
 *
 * ����: 1->2->3->4->5->NULL, m = 2, n = 4
 * ���: 1->4->3->2->5->NULL
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/6/3 3:24 ����
 */
public class ReverseBetween {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // Empty list
        if (head == null) {
            return null;
        }
        // Move the two pointers until they reach the proper starting point
        // in the list.
        ListNode cur = head, prev = null;
        while (m > 1) {
            prev = cur;
            cur = cur.next;
            m--;
            n--;
        }

        // The two pointers that will fix the final connections.
        ListNode con = prev, tail = cur;

        // Iteratively reverse the nodes until n becomes 0.
        ListNode third = null;
        while (n > 0) {
            third = cur.next;
            cur.next = prev;
            prev = cur;
            cur = third;
            n--;
        }

        // Adjust the final connections as explained in the algorithm
        if (con != null) {
            con.next = prev;
        } else {
            head = prev;
        }

        tail.next = cur;
        return head;
    }
}
