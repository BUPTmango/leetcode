package middle_level;

import data_structure.linked_list.ListNode;

/**
 * ����ת�㷨������Ƶ���⡷����
 * 147. ���������в�������
 * ���������в�������
 *
 * ��������Ķ�����ʾ���ϡ��ӵ�һ��Ԫ�ؿ�ʼ�����������Ա���Ϊ�Ѿ����������ú�ɫ��ʾ����
 * ÿ�ε���ʱ���������������Ƴ�һ��Ԫ�أ��ú�ɫ��ʾ������ԭ�ؽ�����뵽���ź���������С�
 *
 * ���������㷨��
 *
 * ���������ǵ����ģ�ÿ��ֻ�ƶ�һ��Ԫ�أ�ֱ������Ԫ�ؿ����γ�һ�����������б���
 * ÿ�ε����У���������ֻ�������������Ƴ�һ���������Ԫ�أ��ҵ������������ʵ���λ�ã���������롣
 * �ظ�ֱ�������������ݲ�����Ϊֹ��
 *
 * ʾ�� 1��
 *
 * ����: 4->2->1->3
 * ���: 1->2->3->4
 * ʾ��2��
 *
 * ����: -1->5->3->4->0
 * ���: -1->0->3->4->5
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/9/26 1:34 ����
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode pre = dummy;
        ListNode cur = head;

        // cur��ʾҪ�����Ԫ��
        while (cur != null) {
            // pre���ζ�ָ�� ָ��Ҫ����λ�õ�ǰһ��Ԫ��
            pre = dummy;
            while (pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }
            // ����cur����һ��Ԫ�� Ҳ���Ǻ��沿��������ͷ�ڵ�
            ListNode next = cur.next;
            // ��ԭ���Ķϵ� �����µ�
            cur.next = pre.next;
            pre.next = cur;
            // ������һ��Ҫ�����λ��
            cur = next;
        }
        return dummy.next;
    }
}