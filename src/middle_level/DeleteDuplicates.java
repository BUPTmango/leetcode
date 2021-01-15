package middle_level;

import data_structure.linked_list.ListNode;

/**
 * ����ת�㷨������Ƶ���⡷���� ��������ͷ�ڵ�
 * 82. ɾ�����������е��ظ�Ԫ�� II
 * ����һ����������ɾ�����к����ظ����ֵĽڵ㣬ֻ����ԭʼ������û���ظ����ֵ����֡�
 * <p>
 * ʾ��1:
 * <p>
 * ����: 1->2->3->3->4->4->5
 * ���: 1->2->5
 * ʾ��2:
 * <p>
 * ����: 1->1->1->2->3
 * ���: 2->3
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/9/25 9:25 ����
 */
public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy, curr = head;
        while (curr != null && curr.next != null) {
            if (prev.next.val == curr.next.val) {
                // ���prev��currָ��Ľڵ�ֵ��ȣ��Ͳ����ƶ�curr��ֱ��prev��currָ���ֵ�����
                while (curr != null && curr.next != null && prev.next.val == curr.next.val) {
                    curr = curr.next;
                }
                prev.next = curr.next;
                curr = curr.next;
            } else {
                prev = prev.next;
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}
