package middle_level;

import data_structure.linked_list.ListNode;

/**
 * ����ת�㷨������Ƶ���⡷����
 * 143. ��������
 * ����һ��������L��L0��L1������Ln-1��Ln ��
 * �����������к��Ϊ�� L0��Ln��L1��Ln-1��L2��Ln-2����
 *
 * �㲻��ֻ�ǵ����ĸı�ڵ��ڲ���ֵ��������Ҫʵ�ʵĽ��нڵ㽻����
 *
 * ʾ��1:
 *
 * �������� 1->2->3->4, ��������Ϊ 1->4->2->3.
 * ʾ�� 2:
 *
 * �������� 1->2->3->4->5, ��������Ϊ 1->5->2->4->3.
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/9/27 9:20 ����
 */
public class ReorderList {
    /**
     * �ҵ��м�ڵ㽫����ֳ����� ��ת��벿�� ֮����������
     * @param head
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        // ����ָ�����е㣬����ֳ�����
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode newHead = slow.next;
        // �����Ϊ����
        slow.next = null;

        // �ڶ���������
        newHead = reverseList(newHead);

        //����ڵ���������
        while (newHead != null) {
            ListNode temp = newHead.next;
            newHead.next = head.next;
            head.next = newHead;
            head = newHead.next;
            newHead = temp;
        }

    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
