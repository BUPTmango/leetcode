package hard_level;

import data_structure.linked_list.ListNode;

/**
 * ��ת����
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
        // ǰ��ͺ�̽ڵ�
        ListNode prev = dummy, successor = null;
        // ��ת����Ķ˵�
        ListNode start = head, end = head;

        while (end != null) {
            // ѭ��k�Σ�ȷ������ת����
            for (int i = 1; i < k && end != null; i++) {
                end = end.next;
            }
            // ���end�ڵ�Ϊ��˵������k����ֱ�ӷ���
            if (end == null) {
                break;
            }
            // �ҵ���̽ڵ�
            successor = end.next;
            // ��Ҫ���� ������ת��������һ���ڵ�ͺ�������Ͽ�
            end.next = null;
            // �������ӷ�ת֮�����������
            prev.next = reverseList(start);
            start.next = successor;
            // �Ա����������¸�ֵ ���������һ��ѭ��
            prev = start;
            start = successor;
            end = successor;
        }

        return dummy.next;
    }

    private ListNode reverseList(ListNode head) {
        ListNode cur = head, pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
