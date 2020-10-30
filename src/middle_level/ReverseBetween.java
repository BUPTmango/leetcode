package middle_level;

import data_structure.linked_list.ListNode;
import util.LinkedListUtil;

/**
 * ��ת����
 * ����ת�㷨������Ƶ���⡷ ����
 * 92. ��ת���� II
 * ��ת��λ�� m �� n ��������ʹ��һ��ɨ����ɷ�ת��
 * <p>
 * ˵��:
 * 1 ��?m?��?n?�� �����ȡ�
 * <p>
 * ʾ��:
 * <p>
 * ����: 1->2->3->4->5->NULL, m = 2, n = 4
 * ���: 1->4->3->2->5->NULL
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/6/3 3:24 ����
 */
public class ReverseBetween {

    /**
     * �������� �Ƽ�
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween_better(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // ǰ���ڵ� �� ��̽ڵ�
        ListNode prev = dummy, successor = null;
        // ��ת���俪ʼ�ڵ�ͽ����ڵ�
        ListNode start = head, end = head;

        // �ҵ�ǰ���ڵ� �� ���俪ʼ�ڵ�
        for (int i = 1; i < m; i++) {
            prev = prev.next;
            start = start.next;
            end = end.next;
        }
        // �ҵ���������ڵ�
        for (int i = m; i < n; i++) {
            end = end.next;
        }
        // �ҵ���̽ڵ�
        successor = end.next;

        // ����ת��������һ���ڵ��ԭ����Ͽ�
        end.next = null;
        // ��ת���ͷ�ڵ�����ǰ���ڵ����
        prev.next = reverseList(start);
        // ��ת��start���β�ڵ㣬�ͺ����������
        start.next = successor;

        return dummy.next;
    }

    private ListNode reverseList(ListNode head) {
        ListNode cur = head, pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * ͷ�巨
     * author������
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) {
            return head;
        }
        ListNode tmpHead = new ListNode(-1);
        tmpHead.next = head;
        head = null;
        ListNode p = tmpHead;
        for (int i = 1; i < m; i++) {
            p = p.next;
        }
        ListNode q = p.next;
        ListNode l = q.next, k = null;
        for (int i = 1; i <= n - m; i++) {
            k = l.next;
            l.next = p.next;
            p.next = l;
            l = k;
        }
        q.next = k;
        head = tmpHead.next;
        return head;
    }
}
