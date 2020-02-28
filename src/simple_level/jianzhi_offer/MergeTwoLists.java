package simple_level.jianzhi_offer;

import data_structure.linked_list.ListNode;

import java.util.List;

/**
 * ������25. �ϲ��������������
 * ����������������������ϲ�����������ʹ�������еĽڵ���Ȼ�ǵ�������ġ�
 *
 * ʾ��1��
 *
 * ���룺1->2->4, 1->3->4
 * �����1->1->2->3->4->4
 * ���ƣ�
 *
 * 0 <= ������ <= 1000
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/2/28 10:12 ����
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode pointer1 = l1;
        ListNode pointer2 = l2;
        ListNode current = new ListNode(0);
        ListNode dummy = current;
        // ������������Ƚϴ�С С�����
        while (pointer1 != null && pointer2 != null) {
            if (pointer1.val < pointer2.val) {
                current.next = pointer1;
                pointer1 = pointer1.next;
            } else {
                current.next = pointer2;
                pointer2 = pointer2.next;
            }
            current = current.next;
        }
        // ����һ��������������󣬽���һ������û�б����Ĳ���ֱ����ӵ������ok
        if (pointer1 == null && pointer2 != null) {
            current.next = pointer2;
        }
        if (pointer1 != null && pointer2 == null) {
            current.next = pointer1;
        }
        return dummy.next;
    }
}
