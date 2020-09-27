package middle_level;

import data_structure.linked_list.ListNode;

/**
 * ����ת�㷨������Ƶ���⡷����
 * 61. ��ת����
 * ����һ��������ת����������ÿ���ڵ������ƶ�k��λ�ã�����k�ǷǸ�����
 *
 * ʾ��1:
 *
 * ����: 1->2->3->4->5->NULL, k = 2
 * ���: 4->5->1->2->3->NULL
 * ����:
 * ������ת 1 ��: 5->1->2->3->4->NULL
 * ������ת 2 ��: 4->5->1->2->3->NULL
 * ʾ��2:
 *
 * ����: 0->1->2->NULL, k = 4
 * ���: 2->0->1->NULL
 * ����:
 * ������ת 1 ��: 2->0->1->NULL
 * ������ת 2 ��: 1->2->0->NULL
 * ������ת 3 ��:0->1->2->NULL
 * ������ת 4 ��:2->0->1->NULL
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/9/27 8:37 ����
 */
public class RotateRight {
    /**
     * �ҵ��ɵ�β��������������ͷ���� old_tail.next = head����������պϳɻ���ͬʱ���������ĳ��� n��
     * �ҵ��µ�β������ (n - k % n - 1) ���ڵ� ���µ�����ͷ�ǵ� (n - k % n) ���ڵ㡣
     * �Ͽ��� new_tail.next = None���������µ�����ͷ new_head��
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }

        // ����β�ڵ�
        ListNode old_tail = head;
        // nΪ������
        int n;
        for(n = 1; old_tail.next != null; n++) {
            old_tail = old_tail.next;
        }
        // ���������ɻ�
        old_tail.next = head;

        // �������β���� n-k-1��λ��
        ListNode new_tail = head;
        for (int i = 0; i < n - k % n - 1; i++) {
            new_tail = new_tail.next;
        }
        // �µ�ͷ���µ�β�͵�next
        ListNode new_head = new_tail.next;

        // β��ָ��null ���ƻ�
        new_tail.next = null;

        return new_head;
    }
}
