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
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode a = dummy;
        ListNode b = head;
        while (b != null && b.next != null) {
            // ��ʼ����ʱaָ������ƽ�㣬���ԱȽ��߼�Ӧ����a����һ���ڵ��b����һ���ڵ�
            if (a.next.val != b.next.val) {
                a = a.next;
                b = b.next;
            } else {
                // ���a��bָ��Ľڵ�ֵ��ȣ��Ͳ����ƶ�b��ֱ��a��bָ���ֵ�����
                while (b != null && b.next != null && a.next.val == b.next.val) {
                    b = b.next;
                }
                a.next = b.next;
                b = b.next;
            }
        }
        return dummy.next;
    }
}
