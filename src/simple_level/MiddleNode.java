package simple_level;

import data_structure.linked_list.ListNode;

/**
 * ����ָ�� ���м�ڵ�
 * 876. ������м���
 * ����һ������ͷ���?head?�ķǿյ���������������м��㡣
 *
 * ����������м��㣬�򷵻صڶ����м��㡣
 *
 * ?
 *
 * ʾ�� 1��
 *
 * ���룺[1,2,3,4,5]
 * ��������б��еĽ�� 3 (���л���ʽ��[3,4,5])
 * ���صĽ��ֵΪ 3 �� (����ϵͳ�Ըý�����л������� [3,4,5])��
 * ע�⣬���Ƿ�����һ�� ListNode ���͵Ķ��� ans��������
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, �Լ� ans.next.next.next = NULL.
 * ʾ��?2��
 *
 * ���룺[1,2,3,4,5,6]
 * ��������б��еĽ�� 4 (���л���ʽ��[4,5,6])
 * ���ڸ��б��������м��㣬ֵ�ֱ�Ϊ 3 �� 4�����Ƿ��صڶ�����㡣
 * ?
 *
 * ��ʾ��
 *
 * ��������Ľ��������?1?��?100?֮�䡣
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/23 10:08 ����
 */
public class MiddleNode {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
