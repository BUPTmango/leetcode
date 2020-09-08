package simple_level.jianzhi_offer;

import data_structure.linked_list.ListNode;

/**
 * ������24. ��ת����
 * ����һ������������һ�������ͷ�ڵ㣬��ת�����������ת�������ͷ�ڵ㡣?
 * <p>
 * ʾ��:
 * <p>
 * ����: 1->2->3->4->5->NULL
 * ���: 5->4->3->2->1->NULL?
 * <p>
 * ���ƣ�
 * <p>
 * 0 <= �ڵ���� <= 5000
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/2/27 9:44 ����
 */
public class ReverseList {
    /**
     * �ݹ鷽��
     * recursive
     *
     * @param head
     * @return
     */
    public ListNode reverseList_recursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList_recursive(head.next);
        // ��ת��ͷ
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * ��������
     * iterative
     *
     * @param head
     * @return
     */
    public ListNode reverseList_iterative(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    /**
     * ͷ�巨 ����head����һ���ڵ�֮��ϵ�head
     * �൱�ھ������ϵĽڵ�һ�������������뵽��������
     * author �� ����
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = head.next;
        head.next = null;
        while (pre != null) {
            ListNode L = pre;
            pre = pre.next;
            L.next = head;
            head = L;
        }
        return head;
    }
}
