package simple_level;

import data_structure.linked_list.ListNode;

/**
 * ����ת�㷨������Ƶ���⡷���� ��������ͷ�ڵ�
 * 203. �Ƴ�����Ԫ��
 * ɾ�������е��ڸ���ֵ val �����нڵ㡣
 *
 * ʾ��:
 *
 * ����: 1->2->6->3->4->5->6, val = 6
 * ���: 1->2->3->4->5
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/8/12 5:48 ����
 */
public class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        // �����ڱ��ڵ�
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;

        ListNode prev = sentinel, curr = head;
        while (curr != null) {
            if (curr.val == val) {
                // ��ͬ Ų��λ
                prev.next = curr.next;
            } else {
                // ��ͬ Ųһλ
                prev = curr;
            }
            curr = curr.next;
        }
        return sentinel.next;
    }
}
