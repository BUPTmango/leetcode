package simple_level;

import data_structure.linked_list.ListNode;

/**
 * ��ת����
 * ����ת�㷨������Ƶ���⡷ ����
 * 206
 * ��תһ��������
 * ʾ��:
 * ����: 1->2->3->4->5->NULL
 * ���: 5->4->3->2->1->NULL
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/2/9 11:28 ����
 */
public class ReverseList {
    /**
     * ˼·��
     * �ܾ�������⣬��������pre,cur,lat����ָ��
     *
     * pre   cur  lat
     * null   1 -> 2 -> 3 -> 4 -> 5 -> null
     * 1
     * 2
     * ����cur.next = pre
     *
     * pre   cur  lat
     * null <-1    2 -> 3 -> 4 -> 5 -> null
     * 1
     * 2
     * ����pre = cur��cur = lat��lat = lat.next
     *
     *       pre  cur  lat
     * null <-1    2 -> 3 -> 4 -> 5 -> null
     * 1
     * 2
     * �ظ���������ֱ��lat=None��
     *
     *                      pre  cur  lat
     * null <-1 <- 2 <- 3 <- 4    5 -> null
     * 1
     * 2
     * ���cur.next = pre���ɡ�
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode lat = cur.next;
        while (lat != null) {
            cur.next = pre;
            pre = cur;
            cur = lat;
            lat = lat.next;
        }
        cur.next = pre;
        return cur;
    }
}
