package hard_level;

import data_structure.linked_list.ListNode;

/**
 * ����ת�㷨������Ƶ���⡷���� ��������ͷ�ڵ�
 * 25. K ��һ�鷭ת����
 * ����һ������ÿk���ڵ�һ����з�ת�����㷵�ط�ת�������
 * <p>
 * k��һ��������������ֵС�ڻ��������ĳ��ȡ�
 * <p>
 * ����ڵ���������k������������ô�뽫���ʣ��Ľڵ㱣��ԭ��˳��
 * <p>
 * ʾ����
 * <p>
 * �����������1->2->3->4->5
 * <p>
 * ��k= 2 ʱ��Ӧ������: 2->1->4->3->5
 * <p>
 * ��k= 3 ʱ��Ӧ������: 3->2->1->4->5
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/9/26 9:22 ����
 */
public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;

        while (head != null) {
            ListNode tail = pre;
            // �鿴ʣ�ಿ�ֳ����Ƿ���ڵ��� k
            for (int i = 0; i < k; ++i) {
                tail = tail.next;
                // ʣ�ಿ�������Ȳ���k ֱ�ӷ��� �����ٷ�ת
                if (tail == null) {
                    return dummy.next;
                }
            }
            ListNode nex = tail.next;
            // ��תhead��tail������
            ListNode[] reverse = myReverse(head, tail);
            head = reverse[0];
            tail = reverse[1];
            // �����������½ӻ�ԭ����
            pre.next = head;
            tail.next = nex;
            // ������һ����Ҫ���ӵ�λ��
            pre = tail;
            head = nex;
        }

        return dummy.next;
    }

    public ListNode[] myReverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode p = head;
        while (prev != tail) {
            ListNode nex = p.next;
            p.next = prev;
            // ����λ��
            prev = p;
            p = nex;
        }
        return new ListNode[]{tail, head};
    }
}
