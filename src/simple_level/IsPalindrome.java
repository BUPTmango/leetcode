package simple_level;

import data_structure.linked_list.ListNode;

/**
 * ����ת�㷨������Ƶ���⡷����
 * 234
 * ��������
 * ���ж�һ�������Ƿ�Ϊ��������
 * <p>
 * ʾ�� 1:
 * <p>
 * ����: 1->2
 * ���: false
 * ʾ�� 2:
 * <p>
 * ����: 1->2->2->1
 * ���: true
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/2/16 10:59 ����
 */
public class IsPalindrome {
    /**
     * �ҵ��м�ڵ� �ֳ���������
     * ��ת�ڶ������� ����������һ���бȽ�
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        ListNode newhead = null;
        slow.next = null;
        // ���ú�������
        while (tmp != null) {
            ListNode cur = tmp.next;
            tmp.next = newhead;
            newhead = tmp;
            tmp = cur;
        }
        // ������������бȽ�
        while (newhead != null) {
            if (newhead.val != head.val) {
                return false;
            }
            newhead = newhead.next;
            head = head.next;
        }
        return true;
    }

}
