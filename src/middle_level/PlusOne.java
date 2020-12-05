package middle_level;

import data_structure.linked_list.ListNode;

/**
 * ����ָ��
 * 369. ���������һ
 * ��һ�� �ǿ� ����������ʾһ���Ǹ�������Ȼ�����������һ��
 *
 * ����Լ�������������� 0 ����û���κ�ǰ���� 0��
 *
 * ��������ĸ�����λ���� ��λ������ͷ������λ������β��?��˳�����С�
 *
 * ʾ��:
 *
 * ����: [1,2,3]
 * ���: [1,2,4]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/12/5 11:24 ����
 */
public class PlusOne {
    /**
     * ����ָ��
     * 1. �ÿ�ָ��fast����������
     * 2. fast.val != 9����ָ���ƶ�����ǰ��ָ�봦
     * 3. fast.val = 9����ָ��ԭ�ز���
     * 4. ������������ָ���ֵ��һ����ָ��������нڵ�ֵ����Ϊ0�������չ���
     * @param head
     * @return
     */
    public ListNode plusOne(ListNode head) {
        ListNode slow = new ListNode(0);
        slow.next = head;
        ListNode fast = head;
        while (fast != null) {
            if (fast.val != 9) {
                slow = fast;
            }
            fast = fast.next;
        }

        slow.val++;

        // ��֮���9���0
        ListNode cur = slow.next;
        while (cur != null) {
            cur.val = 0;
            cur = cur.next;
        }
        // ����ǵ�һλ������9 ��Ҫ��ǰ��λ����slow�ڵ�Ҳ����dummy�ڵ�
        return slow.next == head ? slow : head;
    }
}
